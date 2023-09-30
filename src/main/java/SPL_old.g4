grammar SPL_old;



// keywords
KW_TRUE: 'true';
KW_FALSE: 'false';
KW_VAR: 'var';
KW_PRINT: 'print';
KW_IF: 'if';
KW_ELSE: 'else';
KW_WHILE: 'while';

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
SEMICOLON: ';';
COMMA: ',';

// literals
STRING: '"' [^"]* '"';
NUMBER: [0-9]+ ('.' [0-9]+)?;
IDENTIFIER: [A-Za-z][A-Za-z0-9]*;
WS: [ \t\r\n]+ -> skip;

// grammar rules
program : declaration* EOF ;

declaration : varDecl | statement ;

varDecl : KW_VAR IDENTIFIER ( ASSIGN expression ) ? SEMICOLON #varDeclAndAssign
       | KW_VAR IDENTIFIER  SEMICOLON #simpleVarDecl
       ;

statement : exprStmt
    | ifStmt
    | printStmt
    | whileStmt
    | block ;

exprStmt : expression SEMICOLON ;

ifStmt : KW_IF LPAREN expression RPAREN statement KW_ELSE statement #ifElseStatement
    | KW_IF LPAREN expression RPAREN #simpleIfStatement
    ;

printStmt : KW_PRINT expression SEMICOLON ;

whileStmt : KW_WHILE LPAREN expression RPAREN statement ;

block : LCURLY declaration * RCURLY ;

expression : assignment ;

assignment : IDENTIFIER ASSIGN assignment
    | logic_or ;

logic_or : logic_and ( OR logic_and )* ;

logic_and : equality ( AND equality )* ;

equality : comparison ( ( NEQ | EQ ) comparison )* ;

comparison : term ( ( GT | GTE | LT | LTE ) term )* ;

term : factor ( ( SUB | ADD ) factor ) * ;

factor : unary ( ( MUL | DIV ) unary ) * ;

unary : ( NOT | SUB ) unary
    | primary ;
primary : KW_TRUE | KW_FALSE | NUMBER | STRING
    | LPAREN expression RPAREN
    | IDENTIFIER ;

ident_list: (IDENTIFIER (COMMA IDENTIFIER)*)?;