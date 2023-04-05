grammar BabyCobol;
import BCTokens;

program
    :   identification_division (data_divison)? procedure_division EOF
    ;

identification_division
    :   'IDENTIFICATION DIVISION.' (IDENTIFIER DOT LITERAL DOT)*
    ;

data_divison
    :   'DATA DIVISION.' variable*
    ;

variable
    :   INT IDENTIFIER (picture | like)? (occurs)? DOT
    ;

picture
    :   'PICTURE IS' REPRESENTATION+
    ;

like
    :   'LIKE' identifiers
    ;

occurs
    :   'OCCURS' INT 'TIMES'
    ;

procedure_division
    :   'PROCEDURE DIVISION' using? DOT sentence+
    ;

using
    :   'USING' using_expression+
    ;

using_expression
    :   'BY REFERENCE' identifiers
    |   'BY CONTENT' atomic
    |   'BY VALUE' atomic
    ;

sentence
    :   ((procname DOT)? statement+ DOT)
    ;

procname
    :   identifiers
    ;

statement
    :   accept
    |   add
    |   subtract
    |   divide
    |   multiply
    |   perform
    |   display
    |   stop
    |   if
    |   evaluate
    |   next_sentence
    |   move
    |   loop
    ;

accept
    :   'ACCEPT' identifiers+
    ;

add
    :   'ADD' INT+ 'TO' identifiers
    |   'ADD' INT+ 'TO' INT giving
    ;

subtract
    :   'SUBTRACT' INT+ 'FROM' identifiers
    |   'SUBTRACT' INT+ 'FROM' INT giving
    ;

divide
    :   'DIVIDE' INT 'INTO' identifiers+
    |   'DIVIDE' INT 'INTO' INT giving
    |   'DIVIDE' INT 'INTO' INT giving remainder
    ;

multiply
    :   'MULTIPLY' INT 'BY' identifiers+
    |   'MULTIPLY' INT 'BY' INT giving
    ;

perform
    :   'PERFORM' procname
    ;

display
    :   'DISPLAY' atomic+ withnoadvancing?
    ;

stop
    :   'STOP'
    ;

if
    :   'IF' boolean_expression 'THEN' i+=statement+ ('ELSE' e+=statement+)? 'END'
    ;

evaluate
    :   'EVALUATE' any_expression when_block* 'END'
    ;

next_sentence
    :   'NEXT SENTENCE'
    ;

move
    :   'MOVE' atomic 'TO' IDENTIFIER+
    ;

loop
    :   'LOOP' loop_expression* 'END'
    ;

remainder
    :   'REMAINDER' identifiers
    ;

giving
    :   'GIVING' identifiers
    ;

withnoadvancing
    :   'WITH NO ADVANCING'
    ;

loop_expression
    :   'VARYING' identifiers? ('FROM' from=atomic)? ('TO' to=atomic)? ('BY' by=atomic)?    #loop_varying_expression
    |   'WHILE' boolean_expression                                                          #loop_while_expression
    |   'UNTIL' boolean_expression                                                          #loop_until_expression
    |   statement                                                                           #loop_statement_expession
    ;

any_expression
    :   arithmetic_expression
    |   string_expression
    |   boolean_expression
    ;

arithmetic_expression
    :   atomic
    |   arithmetic_expression ARITHMETIC_OPERATOR arithmetic_expression
    ;

string_expression
    :   atomic
    |   string_expression '+' string_expression
    ;

boolean_expression
    :   'TRUE'
    |   'FALSE'
    |   arithmetic_expression COMPARISON_OPERATOR arithmetic_expression
    |   'NOT' boolean_expression
    |   boolean_expression BOOLEAN_OPERATOR boolean_expression
    ;

when_block
    :   'WHEN' atomic statement+
    |   'WHEN OTHER' statement+
    ;

atomic
    :   identifiers
    |   INT
    |   LITERAL
    ;

identifiers
    :   IDENTIFIER ('OF' IDENTIFIER)* ('(' INT ')')?
    ;