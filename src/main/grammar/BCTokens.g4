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

IDENTIFIER
    :   VAR ('-' VAR)* INT?
    ;

VAR
    :   [a-zA-Z]+
    ;

INT
    :   [0-9]+
    ;

LITERAL
    :   '"' ~'"'+ '"'
    ;

DOT
    :   '.'
    ;

WS
    :   [ \r\n\t\f]+ -> skip
    ;