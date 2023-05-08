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
PICTURE: 'P' SPACE* 'I' SPACE* 'C' SPACE* 'T' SPACE* 'U' SPACE* 'R' SPACE* 'E' ;
IS: 'I' SPACE* 'S' ;
LIKE: 'L' SPACE* 'I' SPACE* 'K' SPACE* 'E' ;
OCCURS: 'O' SPACE* 'C' SPACE* 'C' SPACE* 'U' SPACE* 'R' SPACE* 'S' ;
TIMES: 'T' SPACE* 'I' SPACE* 'M' SPACE* 'E' SPACE* 'S' ;
USING: 'U' SPACE* 'S' SPACE* 'I' SPACE* 'N' SPACE* 'G' ;
BY: 'B' SPACE* 'Y' ;
REFERENCE: 'R' SPACE* 'E' SPACE* 'F' SPACE* 'E' SPACE* 'R' SPACE* 'E' SPACE* 'N' SPACE* 'C' SPACE* 'E' ;
CONTENT: 'C' SPACE* 'O' SPACE* 'N' SPACE* 'T' SPACE* 'E' SPACE* 'N' SPACE* 'T';
VALUE: 'V' SPACE* 'A' SPACE* 'L' SPACE* 'U' SPACE* 'E' ;
PROCEDURE: 'P' SPACE* 'R' SPACE* 'O' SPACE* 'C' SPACE* 'E' SPACE* 'D' SPACE* 'U' SPACE* 'R' SPACE* 'E' ;
DIVISION: 'D' SPACE* 'I' SPACE* 'V' SPACE* 'I' SPACE* 'S' SPACE* 'I' SPACE* 'O' SPACE* 'N' ;
TO: 'T' SPACE* 'O' ;
FROM: 'F' SPACE* 'R' SPACE* 'O' SPACE* 'M' ;
INTO: 'I' SPACE* 'N' SPACE* 'T' SPACE* 'O' ;
THROUGH: 'T' SPACE* 'H' SPACE* 'R' SPACE* 'O' SPACE* 'U' SPACE* 'G' SPACE* 'H' ;
SENTENCE:  'S' SPACE* 'E' SPACE* 'N' SPACE* 'T' SPACE* 'E' SPACE* 'N' SPACE* 'C' SPACE* 'E' ;
NEXT: 'N' SPACE* 'E' SPACE* 'X' SPACE* 'T' ;
THEN: 'T' SPACE* 'H' SPACE* 'E' SPACE* 'N' ;
ELSE: 'E' SPACE* 'L' SPACE* 'S' SPACE* 'E' ;
END: 'E' SPACE* 'N' SPACE* 'D' ;
GO: 'G' SPACE* 'O' ;
WITH: 'W' SPACE* 'I' SPACE* 'T' SPACE* 'H' ;
NO: 'N' SPACE* 'O' ;
ADVANCING: 'A' SPACE* 'D' SPACE* 'V' SPACE* 'A' SPACE* 'N' SPACE* 'C' SPACE* 'I' SPACE* 'N' SPACE* 'G' ;
GIVING: 'G' SPACE* 'I' SPACE* 'V' SPACE* 'I' SPACE* 'N' SPACE* 'G' ;
REMAINDER: 'R' SPACE* 'E' SPACE* 'M' SPACE* 'A' SPACE* 'I' SPACE* 'N' SPACE* 'D' SPACE* 'E' SPACE* 'R' ;
OF: 'O' SPACE* 'F' ;
WHEN: 'W' SPACE* 'H' SPACE* 'E' SPACE* 'N' ;
OTHER: 'O' SPACE* 'T' SPACE* 'H' SPACE* 'E' SPACE* 'R' ;
TRUE: 'T' SPACE* 'R' SPACE* 'U' SPACE* 'E' ;
FALSE: 'F' SPACE* 'A' SPACE* 'L' SPACE* 'S' SPACE* 'E' ;
NOT: 'N' SPACE* 'O' SPACE* 'T' ;
VARYING: 'V' SPACE* 'A' SPACE* 'R' SPACE* 'Y' SPACE* 'I' SPACE* 'N' SPACE* 'G' ;
UNTIL: 'U' SPACE* 'N' SPACE* 'T' SPACE* 'I' SPACE* 'L' ;
WHILE: 'W' SPACE* 'H' SPACE* 'I' SPACE* 'L' SPACE* 'E' ;
IDENTIFICATION: 'I' SPACE* 'D' SPACE* 'E' SPACE* 'N' SPACE* 'T' SPACE* 'I' SPACE* 'F' SPACE* 'I' SPACE* 'C' SPACE* 'A' SPACE* 'T' SPACE* 'I' SPACE* 'O' SPACE* 'N' ;
DATA: 'D' SPACE* 'A' SPACE* 'T' SPACE* 'A' ;
SIGNAL: 'S' SPACE* 'I' SPACE* 'G' SPACE* 'N' SPACE* 'A' SPACE* 'L';
ON: 'O' SPACE* 'N' ;
ERROR: 'E' SPACE* 'R' SPACE* 'R' SPACE* 'O' SPACE* 'R' ;
OFF: 'O' SPACE* 'F' SPACE* 'F' ;


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