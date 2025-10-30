grammar MyLangMinus;

start
  : stmt* EOF
  ;

stmt
  : ID '=' expr ';'
  | expr ';'
  ;

expr
  : expr '*' expr
  | expr '+' expr
  | ID
  | NUM
  ;


ID  : [a-zA-Z_] [a-zA-Z_0-9]* ;
NUM : [0-9]+ ;

WS  : [ \t\r\n]+ -> skip ;
