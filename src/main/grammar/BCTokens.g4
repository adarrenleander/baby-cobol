lexer grammar BCTokens;

VAR
    :   [a-zA-Z][a-zA-Z0-9-]*
    ;

INT
    :   [0-9]+
    ;

WS
    :   [ \t\r\n\f]+ -> skip
    ;

DOT: '.';
