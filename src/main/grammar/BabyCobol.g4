grammar BabyCobol;
import BCTokens;

program : statements+ ;
statements : accept | add | subtract ;
accept  : 'ACCEPT ' VAR ;
add : 'ADD ' INT 'TO ' VAR ;
subtract : 'SUBTRACT ' INT 'FROM ' VAR ;