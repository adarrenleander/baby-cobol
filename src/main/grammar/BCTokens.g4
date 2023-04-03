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

VAR
    :   [a-zA-Z]+
    ;

INT
    :   [0-9]+
    ;

DOT
    :   '.'
    ;

WS
    :   [ \r\n\t\f]+ -> skip
    ;