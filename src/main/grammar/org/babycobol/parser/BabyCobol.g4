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
    |   move
    ;

accept
    :   ACCEPT VAR+
    ;

add
    :   'ADD' INT+ 'TO' singlevar
    |   'ADD' INT+ 'TO' INT giving
    ;

subtract
    :   'SUBTRACT' INT+ 'FROM' VAR
    |   'SUBTRACT' INT+ 'FROM' INT giving
    ;

giving
    :   'GIVING' singlevar
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
move
    :   MOVE (INT|singlevar) 'TO' multivar
    ;

multivar : VAR+ ;
singlevar : VAR+ ;
