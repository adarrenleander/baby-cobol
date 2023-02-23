grammar BabyCobol;
import BCTokens;

program
    :   statements+
    ;

statements
    :   accept
    |   add
    |   subtract
    ;

accept
    :   'ACCEPT' VAR+
    ;

add
    :   'ADD' INT+ 'TO' VAR
    |   'ADD' INT+ 'TO' INT giving
    ;

giving
    :   'GIVING' VAR
    ;

subtract
    :   'SUBTRACT' INT 'FROM' VAR
    ;