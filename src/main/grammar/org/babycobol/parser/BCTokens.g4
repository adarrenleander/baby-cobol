lexer grammar BCTokens;

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

IDENTIFIER
    :   VAR ('-' VAR)* INT?
    ;

LITERAL
    :   '"' ~'"'+ '"'
    ;

MOVE : 'M' SPACE* 'O' SPACE* 'V' SPACE* 'E' ;
ACCEPT : 'A' SPACE* 'C' SPACE* 'C' SPACE* 'E' SPACE* 'P' SPACE* 'T' ;


VAR :   LETTER ( LETTER | DIGIT | '-' )* ;
INT :   DIGIT+ ;
SPACE : [ \t\r\n\f] -> skip ;
DOT: '.';

fragment LETTER : [a-zA-Z] ;
fragment DIGIT : [0-9] ;
