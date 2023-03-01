grammar BabyCobol;
import BCTokens;

program
    :   statements+
    ;

statements
    :   accept
    |   add
    |   subtract
    |   stop
    |   display
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

giving
    :   'GIVING' VAR
    ;

display
    :   'DISPLAY' INT
    |   'DISPLAY' VAR
    ;


stop
    : 'STOP'
    ;
