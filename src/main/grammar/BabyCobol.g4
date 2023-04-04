grammar BabyCobol;
import BCTokens;

program
    :   identification_division (data_divison)? procedure_division EOF
    ;

identification_division
    :   'IDENTIFICATION DIVISION.' (IDENTIFIER DOT LITERAL DOT)*
    ;

data_divison
    :   'DATA DIVISION.' (INT IDENTIFIER DOT)*
    ;

procedure_division
    :   'PROCEDURE DIVISION.' sentence+
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

remainder
    :   'REMAINDER' identifiers
    ;

giving
    :   'GIVING' identifiers
    ;

withnoadvancing
    :   'WITH NO ADVANCING'
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