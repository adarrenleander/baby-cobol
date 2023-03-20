lexer grammar BCTokens;

MOVE : 'M' SPACE* 'O' SPACE* 'V' SPACE* 'E' ;
ACCEPT : 'A' SPACE* 'C' SPACE* 'C' SPACE* 'E' SPACE* 'P' SPACE* 'T' ;


VAR :   LETTER ( LETTER | DIGIT | '-' )* ;
INT :   DIGIT+ ;
SPACE : [ \t\r\n\f] -> skip ;
DOT: '.';

fragment LETTER : [a-zA-Z] ;
fragment DIGIT : [0-9] ;
