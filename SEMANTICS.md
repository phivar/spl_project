## SPL Semantik

### Variationspunkte

#### 1. Implizite Boolean-Konvertierung: 
Es gibt keine impliziten Typkonvertierungen. Stattdessen können builtin-Funktionen benutzt werden um das gewünschte Verhalten zu erreichen. 

```js
if("hello") {} // type error!
if(string_length("hello") > 0) {} // works
```

#### 2. Operator-Überladung: 
Operatoren sind nicht weiter überladen, stattdessen kann das Verhalten durch builtin-Funktionen erreicht werden:
```js
"asdf" + "asdf"; // type error!
"asdf" + true; // type error!
string_concat("asdf","asdf"); // okay
string_concat("bool: ",to_string(false)); // okay
```
#### 3. Neudefinition von Variablen: 
Variablen dürfen in einem Gültigkeitsbereich/Scope nur einmal definiert werden.
```js
var a;
var a; // name error!
``` 
#### 4. Shadowing und Scoping
Variablen können in inneren Scopes neu definiert werden. Dies führt zu shadowing; das Modifizieren der inneren neu definierten Variable verändert nicht die äußere:
```js
var a = 0.0;
{
	var a = 1.0;
	print a; // 1.0
}
print a; // 0.0
```

#### Uninitialisierte Variablen:
Variablen können uninitialisiert deklariert werden `var a;` allerdings dürfen sie vor der ersten Zuweisung nicht in Ausdrücken benutzt werden.
```js
var a;
a = 10;
print a; // okay
var b = 10;
print b; // okay
var c;
print c; // name error! 
```


