lexer grammar BCTokens;

REPRESENTATION
    :   '9'
    |   'A'
    |   'X'
    |   'Z'
    |   'S'
    |   'V'
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

LITERAL
    :   '"' ~'"'+ '"'
    ;

IDENTIFIER :   LETTER ( LETTER | DIGIT | '-' )* ;
INT :   DIGIT+ ;
SPACE : [ \t\r\n\f] -> skip ;
DOT: '.';

fragment LETTER : [a-zA-Z] ;
fragment DIGIT : [0-9] ;
