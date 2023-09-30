## SPL Erweiterungen

### Lexer-Erweiterungen

Identifier dürfen auch `_` enthalten:
`IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]*`

Weitere Keywords eingeführt:
`return, func, any, bool, number, string, list`

### Grammatikalische Erweiterungen und Veränderungen

#### Typ-Annotationen in VarDecl

Variablendeklarationen dürfen optional mit einer Typ-Annotation markiert werden:
```ts
var a: number = 10.0;
var b: string;
```
Die Semantik wird weiter unten im dazugehörigen Abschnitt erklärt.
Dies wird durch die Veränderung der varDecl-Regel erreicht:
```ebnf
varDecl : KW_VAR boundedIdent ASSIGN expression SEMICOLON #varDeclAndAssign
       | KW_VAR ident=IDENTIFIER SEMICOLON                #simpleVarDecl
       ;

boundedIdent: ident=IDENTIFIER (COLON bound = type)?;

type : KW_ANY | KW_BOOL | KW_NUMBER | KW_STRING | KW_LIST | KW_FUNC
    ;
```
#### Vereinfachung der Expression-Parsing Grammatikregeln

In der ursprünglichen Spezifikation von SPL auf Moodle finden sich die Regeln
`expression, assignment, logic_or, logic_and, equality, comparison, term, factor, unary, primary`
welche bewerkstelligen, dass ein Ausdruck mit den korrekten Operatorprioritäten geparsed wird. 
In ANTLRv4 können wir dies jedoch wesentlich einfacher erreichen:
```ebnf
term : primary                  #primaryTerm
    | term LPAREN arguments=expressionList RPAREN  #functionCallTerm
    | op=(NOT|SUB) term            #unaryTerm
    | term op=(MUL|DIV) term       #mulDivTerm
    | term op=(ADD|SUB) term       #addSubTerm
    | term op=(GT|GTE|LT|LTE) term #comparisonTerm
    | term op=(NEQ|EQ) term        #equalityTerm
    | term AND term             #andTerm
    | term OR term              #orTerm
    ;
```
Die Regeln `logic_or, logic_and, equality, comparison, term, factor, unary` wurden also eliminiert und durch die obere ersetzt. Dies parsed immer noch mit den korrekten Operatorprioritäten da ANTLR bei default den höheren Branches höhere Priorität gibt.

#### Funktionsaufrufe, Funktionsausdrücke und Listen
Wie in der obigen `term` Regel zu sehen, wurde eine Regel für das Aufrufen von Funktionen hinzugefügt wurde:
`term : ... | term LPAREN arguments=expressionList RPAREN  #functionCallTerm | ...; `
Dazu gehört auch:
`expressionList: (expression (COMMA expression)*)?;`
Damit sind zum Beispiel folgendes Programm erlaubt:
```ts
var a = my_function("hello", 123 + 123);
```
Die Semantik von Funktionen folgt später. 
Zudem wurde die `primary` Regel erweitert, um die Definition von Listen und Funktionen zu erlauben:

```ebnf
primary : KW_TRUE | KW_FALSE | NUMBER | STRING
    | LPAREN expression RPAREN
    | LSQUARE expressionList RSQUARE
    | KW_FUNC LPAREN paramList RPAREN block
    | ident=IDENTIFIER ;

paramList : (boundedIdent ( COMMA boundedIdent)*)?;
```
Zeile 3 erlaubt bspw. `[1,2,"adsf",true]` und Zeile 4 `func(x, y, z){}`.
Dabei `boundedIdent` wurde schon in `varDecl` benutzt; so etwas, wie `func(x: number, y: any){}` ist also auch ein syntaktisches `primary`. Die Semantik hierzu findet sich weiter unten. 

#### Return-Statement
Es wurde ein weiteres Statement eingeführt:
```ebnf
statement : exprStmt
    | ifStmt
    | printStmt
    | returnStmt
    | whileStmt
    | block
    ;

returnStmt: KW_RETURN (expression)? SEMICOLON ;
```
Somit sind  `return 12.0;` oder `var f = func(x){return;};` legale Programme.

### Funktionen

#### Einfache Definition:
```ts
var add = func(x,y){
	return x+y;
}; // don't forget the semicolon!
print add(1,1); // 2

var useless = func(){};
```

#### Funktionen als Werte

Das Ausrufen einer Funktion hat die Grammatik `term : ... | term ( expressionList ) | ... ;` dementsprechend ist folgendes syntaktisch möglich, aber semantisch verboten:

```ts
var a = 10.0;
(a+a)(); // type error!
```

Ausserdem, da Funktionsdefinitionen Werte sind, können sie sofort ausgeführt werden ohne sie in einer Variable zwischenzuspeichern.
```ts
var a = func(x){return x;}(10.0);
print a; // 10.0
```

Eine weitere Konsequenz ist, dass Funktionen in sich selbst Funkionen definieren und zurückgeben können:
```ts
var adder = func(x){
	return func(y){return x+y;};
};
print adder(5)(10); // 15 
```

Zudem können Funktionen auch Funktionen übergeben werden:
```ts
var add = func(x,y){return x+y;};
var bind_first = func(f,x){
	return func(y){return f(x,y);};
};
print bind_first(add,5)(10); // 15
```

#### Rekursion
Rekursion ist möglich, da nach der Definition der Funktion der Name im überliegenden Scope eingetragen ist:
```ts
var factorial = func(n){
	if(n == 1) return 1;
	return n*factorial(n-1);
};
var fib = func(n){
	if(n == 0) return 0;
	if(n == 1) return 1;
	return fib(n-1)+fib(n-2);
};
print factorial(5);
print fib(5);
```

#### Equality für Funktionen:
Funktionen sind Referenztypen werden bei jedem nutzen von `func` neu erstellt und sind immer nur gleich sich selbst. 
```ts
var f = func(){};
var g = func(){return func(){};};
var h = f;
print f == f; // true
print f == h; // true
print g == f; // false
print f == func(){}; // false
print g() == g(); // false
```
### Typ-Annotationen

Manchmal möchte man eine Variable zwingen nur einen bestimmten Typ anzunehmen.
Dafür kann man Sie mit einer Typ-Annotation markieren:
```ts
var a: string = 10.0; // type error!
var b: number = 10.0; // okay
b = "asdf"; //type error!
var c: any = 10.0; //okay
c = "hi"; //okay
var d: func = func(){};
```
Diese Annotationen werden bei jeder Zuweisung dynamisch gecheckt. 
Bei default ist alles als `any` markiert. 
Die verfügbaren Typ-Annotationen sind `any | bool | string | number | list | func`.

#### Parameter Typ-Annotationen in Funktionen
Typ-Annotationen können auch in Funktionsparameterlisten benutzt werden:
```ts
var add: func = func(x: number, y: number){
	return x+y;
};
add(1,"asdf"); // type error before trying to add

var bind_first = func(f: func, x){
	return func(y: any){return f(x,y);};
}
```

#### Anmerkung zum Return-Statement
Ein Return-Statement kann auch leer sein `return;` oder eine Funktion enthält überhaupt keins `func(){};` -  in diesem Fall wird die Funktion verlassen ohne einen Wert zurückzugeben bzw. sie gibt einen Interpreter-internen `void`-Wert zurück; es ist aber verboten diesen einer Variable zuzuweisen. Siehe hierzu unten `technischer VOID-Typ`.
Wenn `return` im global scope genutzt wird, ended das Programm. 
```ts
print "hello";
return;
print "unreachable";
```

### Weitere Typen

#### Listen
Sind heterogene dynamische Listen analog z.B. Python, die in Java als `ArrayList<Value>` implementiert sind. Die builtin-Funktionen hierzu finden sich weiter unten. 
```ts
var a = ["abc",1.0]; // eine Liste
list_append(a,true); // builtin function später mehr
print a; // [abc,1.0,true]
```
Listen sind gleich wenn sie gleich lang sind und ihre Inhalte rekursiv gleich vergleichen:
```ts
print [] == []; 		// true
print [[]] == [[]]; 	// true
print [1.0] == []; 		// false
print [1.0] == [true]; 	// false
```

Listen sind Referenztypen:
```ts
var x = [];
var y = [x];
list_append(list_get(y,0), 1.0);
print x; // [1.0]
```


#### technischer VOID Typ
Was geben Funktionen ohne return-Statement oder mit `return;` zurück?
```ts
var f = func(){};
f(); // okay
var out = f(); // type error! 
```
mit der Meldung:
`tried to assign VOID to variable out; variables can't have type void!`
Im Grunde ist eine Instanz vom Void-Typ nur als return-Wert erlaubt, darf aber niemals einer Variable zugewiesen werden. `list_append(list,val)` gibt z.B. auch `void` zurück. 
Das eine Variable niemals eine `void`-Instanz zugewiesen werden kann, liegt daran, dass der VOID-Typ keine der möglich Typ-Annotation erfüllt, insb. nicht `any`. In einem Ausdruck kann es aber auftauchen. Also ist folgendes möglich:
```ts
var f = func(){};
print f(); // prints VOID
```
Aber folgendes resultiert in einem Fehler, da das Übergeben von Argumenten an eine Funktion mit der Typ-Annotation (welche ja `any` bei default ist) des Funktionsparameter gecheckt wird:
```ts
var f = func(){};
var id = func(x){return x;};
id(f()); // type error 
```
mit der Nachricht: `expected argument 1 for parameter <x> to satisfy type bound <ANY> found <VOID>!`.
Alle Operationen mit VOID sollten in einem Typfehler resultieren:
```ts
var f = func(){};
f() == f();  // type error
f() == true; // type error
f() > 123.0; // type error
```

### builtin-Funktionen:
Es gibt einige builtin-Funktionen die an Java-Methoden gebunden sind und in den global scope eingetragen werden. Die Namen implizieren ihre Funktionalität:
- `string_concat(a: string, b: string)` returns string
- `string_length(x: string)` returns number
- `list_append(lst: list, x: any)` returns void
- `list_length(lst: list)` returns number
- `list_get(lst: list, index: number)` return any; if the passed index has a fractional part or is out of bounds, it throws a runtime exception
- `list_set(lst: list, index: number, value: any)` returns void
- `float_sin(x: number)` returns number
- `float_cos(x: number)`returns number
- `to_string(x: any)` returns string
