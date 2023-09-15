grammar SPL;

// comments
COMMENT: '//' ~[\n]* -> skip;

// keywords
KW_TRUE: 'true';
KW_FALSE: 'false';
KW_VAR: 'var';
KW_PRINT: 'print';
KW_IF: 'if';
KW_ELSE: 'else';
KW_WHILE: 'while';
KW_RETURN: 'return';
KW_FUNC: 'func';
KW_NUMBER: 'number';
KW_BOOL: 'bool';
KW_STRING: 'string';
KW_ANY: 'any';
KW_LIST: 'list';

// operators
MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;

// compare
NEQ : '!=' ;
GTE : '>=' ;
LTE : '<=' ;
GT  : '>' ;
LT  : '<' ;
EQ  : '==' ;

// logic
NOT: '!';
AND: 'and';
OR: 'or';

// stuff
ASSIGN : '=';
LPAREN: '(';
RPAREN: ')';
LCURLY: '{';
RCURLY: '}';
LSQUARE: '[';
RSQUARE: ']';
SEMICOLON: ';';
COLON: ':';
COMMA: ',';

// literals
STRING: '"' ~["]* '"';
NUMBER: [0-9]+ ('.' [0-9]+)?;
IDENTIFIER: [A-Za-z_][A-Za-z0-9_]*; //TODO added underscore
WS: [ \t\r\n]+ -> skip;

// grammar rules
program : declartionList EOF ;

declaration : varDecl | statement;
declartionList : declaration*;

varDecl : KW_VAR boundedIdent ASSIGN expression SEMICOLON   #varDeclAndAssign
       | KW_VAR ident=IDENTIFIER SEMICOLON                      #simpleVarDecl
       ;

boundedIdent: ident=IDENTIFIER (COLON bound = type)?;

type : KW_ANY | KW_BOOL | KW_NUMBER | KW_STRING | KW_LIST | KW_FUNC
    ;

statement : exprStmt
    | ifStmt
    | printStmt
    | returnStmt
    | whileStmt
    | block
    ;

exprStmt : expression SEMICOLON ;

ifStmt : KW_IF LPAREN expression RPAREN statement KW_ELSE statement     #ifElseStatement
    | KW_IF LPAREN expression RPAREN statement                          #simpleIfStatement
    ;

printStmt : KW_PRINT expression SEMICOLON ;

returnStmt: KW_RETURN expression SEMICOLON ;

whileStmt : KW_WHILE LPAREN expression RPAREN statement ;

block : LCURLY declartionList RCURLY ;

expression : assignment ;

expressionList: (expression (COMMA expression)*)?;

assignment : IDENTIFIER ASSIGN assignment #identifierAssign
    | term #emptyAssign
    ;

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

primary : KW_TRUE | KW_FALSE | NUMBER | STRING
    | LPAREN expression RPAREN
    | LSQUARE expressionList RSQUARE
    | KW_FUNC LPAREN paramList RPAREN block
    | ident=IDENTIFIER ;

paramList : (boundedIdent ( COMMA boundedIdent)*)?;


