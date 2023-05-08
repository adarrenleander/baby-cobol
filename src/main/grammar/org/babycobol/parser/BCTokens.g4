lexer grammar BCTokens;

REPRESENTATION
    :   REPR+
    ;

COMPARISON_OPERATOR
    :   '='
    |   '>'
    |   '<'
    |   '>='
    |   '<='
    ;

BOOLEAN_OPERATOR
    :   'OR'
    |   'AND'
    |   'XOR'
    ;

ARITHMETIC_OPERATOR
    :   '+'
    |   '-'
    |   '*'
    |   '/'
    |   '**'
    ;

ADD : 'A' SPACE * 'D' SPACE* 'D' ;
MOVE : 'M' SPACE * 'O' SPACE* 'V' SPACE* 'E' ;
ACCEPT : 'A' SPACE * 'C' SPACE* 'C' SPACE* 'E' SPACE* 'P' SPACE* 'T' ;
DISPLAY : 'D' SPACE * 'I' SPACE* 'S' SPACE* 'P' SPACE* 'L' SPACE* 'A' SPACE* 'Y' ;
PERFORM : 'P' SPACE* 'E' SPACE* 'R' SPACE* 'F' SPACE* 'O' SPACE* 'R' SPACE* 'M' ;
STOP : 'S' SPACE* 'T' SPACE* 'O' SPACE* 'P' ;
SUBTRACT : 'S' SPACE* 'U' SPACE* 'B' SPACE* 'T' SPACE* 'R' SPACE* 'A' SPACE* 'C' SPACE* 'T' ;
DIVIDE: 'D' SPACE* 'I' SPACE* 'V' SPACE* 'I' SPACE* 'D' SPACE* 'E' ;
MULTIPLY: 'M' SPACE* 'U' SPACE* 'L' SPACE*  'T' SPACE* 'I' SPACE* 'P' SPACE* 'L' SPACE* 'Y' ;
IF: 'I' SPACE* 'F' ;
EVALUATE: 'E' SPACE* 'V' SPACE* 'A' SPACE* 'L' SPACE* 'U' SPACE* 'A' SPACE* 'T' SPACE* 'E' ;
LOOP: 'L' SPACE*  'O' SPACE* 'O' SPACE* 'P' ;


LITERAL
    :   '"' ~'"'+ '"'
    ;

COPY_LITERAL
    :   '===' ~'='+ '==='
    ;

IDENTIFIER
    :   LETTER ( LETTER | DIGIT | '-' )* ( '(' DIGIT ')' )?
    ;

INT
    :   DIGIT+
    ;

SPACE
    :   [ \t\r\n\f] -> skip
    ;

DOT
    :   '.'
    ;

fragment LETTER
    :   [a-zA-Z]
    ;

fragment DIGIT
    :   [0-9]
    ;

fragment REPR  // these values can no longer be used as variables/procnames in the code
    :   '9'
    |   'A'
    |   'X'
    |   'Z'
    |   'S'
    |   'V'
    ;