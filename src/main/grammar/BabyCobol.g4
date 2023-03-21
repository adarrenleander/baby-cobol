grammar BabyCobol;
import BCTokens;

program
    :   sentence+
    ;

sentence : ((procname DOT)? statement+ DOT) ;

procname: VAR;

statement
    :   accept
    |   add
    |   subtract
    |   perform
    |   display
    |   stop
    |   divide
    |   multiply
    ;

accept
    :   'ACCEPT' VAR+
    ;

add
    :   'ADD' INT+ 'TO' VAR
    |   'ADD' INT+ 'TO' INT giving
    ;

subtract
    :   'SUBTRACT' INT+ 'FROM' VAR
    |   'SUBTRACT' INT+ 'FROM' INT giving
    ;

divide
    :   'DIVIDE' INT 'INTO' VAR+
    |   'DIVIDE' INT 'INTO' INT giving
    |   'DIVIDE' INT 'INTO' INT giving remainder
    ;

multiply
    :   'MULTIPLY' INT 'BY' VAR+
    |   'MULTIPLY' INT 'BY' INT giving
    ;

giving
    :   'GIVING' VAR
    ;

display
    :   'DISPLAY' (INT|VAR)+ withnoadvancing?
    ;

withnoadvancing
    : 'WITH NO ADVANCING'
    ;

stop
    : 'STOP'
    ;

perform
    : 'PERFORM' procname
    ;

remainder
    :   'REMAINDER' VAR
    ;

when
    :   'WHEN' statement+
    ;
