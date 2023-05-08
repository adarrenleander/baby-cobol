grammar BabyCobol;
import BCTokens;

program
    :   identification_division (data_division)? procedure_division EOF
    ;

identification_division
    :   IDENTIFICATION DIVISION DOT (IDENTIFIER DOT LITERAL DOT)*
    ;

data_division
    :   DATA DIVISION DOT variable*
    ;

variable
    :   INT IDENTIFIER (picture | like)? (occurs)? DOT
    ;

picture
    :   PICTURE IS REPRESENTATION
    ;

like
    :   LIKE identifiers
    ;

occurs
    :   OCCURS INT TIMES
    ;

procedure_division
    :   PROCEDURE DIVISION using? DOT sentence+
    ;

using
    :   USING using_expression+
    ;

using_expression
    :   BY REFERENCE identifiers
    |   BY CONTENT atomic
    |   BY VALUE atomic
    ;

sentence
    :   (procname DOT)? statement+ DOT
    ;

procname
    :   IDENTIFIER
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
    |   goto
    ;

accept
    :    ACCEPT IDENTIFIER+
    ;


add
    :   ADD additions+=INT+ TO identifiers
    |   ADD additions+=INT+ TO base=INT giving
    ;

subtract
    :   SUBTRACT subtractors+=INT+ FROM identifiers
    |   SUBTRACT subtractors+=INT+ FROM base=INT giving
    ;

divide
    :   DIVIDE divisor=INT INTO identifiers+
    |   DIVIDE divisor=INT INTO base=INT giving
    |   DIVIDE divisor=INT INTO base=INT giving remainder
    ;

multiply
    :   MULTIPLY multiplier=INT BY identifiers+
    |   MULTIPLY multiplier=INT BY base=INT giving
    ;

perform
    :   PERFORM  procname through?
    ;

through: THROUGH procname;

display
    :   DISPLAY  atomic+ withnoadvancing?
    ;

stop
    :   STOP
    ;

if
    :   IF boolean_expression THEN i+=statement+ (ELSE e+=statement+)? END
    ;

evaluate
    :   EVALUATE any_expression when_block* END
    ;

next_sentence
    :   NEXT SENTENCE
    ;

loop
    :   LOOP loop_expression* END
    ;

goto
    :   GO TO IDENTIFIER
    ;

move
    :   MOVE (INT | singlevar) TO multivar
    ;

multivar
    :   IDENTIFIER+
    ;

singlevar
    :   IDENTIFIER+
    ;

remainder
    :   REMAINDER identifiers
    ;

giving
    :   GIVING identifiers
    ;

withnoadvancing
    :   WITH NO ADVANCING
    ;

loop_expression
    :   VARYING identifiers? (FROM from=atomic)? (TO to=atomic)? (BY by=atomic)?    #loop_varying_expression
    |   WHILE boolean_expression                                                          #loop_while_expression
    |   UNTIL boolean_expression                                                          #loop_until_expression
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
    :   TRUE
    |   FALSE
    |   arithmetic_expression COMPARISON_OPERATOR arithmetic_expression
    |   NOT boolean_expression
    |   boolean_expression BOOLEAN_OPERATOR boolean_expression
    ;

when_block
    :   WHEN atomic statement+
    |   WHEN OTHER statement+
    ;

atomic
    :   identifiers
    |   INT
    |   LITERAL
    ;

identifiers
    :   IDENTIFIER (OF IDENTIFIER)* ('(' INT ')')?
    ;