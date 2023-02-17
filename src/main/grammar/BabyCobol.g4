grammar BabyCobol;
import BCTokens;

program : statements+ ;
statements : accept | add ;
accept  : 'ACCEPT ' VAR ;
add : 'ADD ' INT 'TO ' VAR ;