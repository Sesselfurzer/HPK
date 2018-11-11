grammar Grammar;

WS: [ \t]+ -> skip;

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];

ID: LETTER (LETTER|DIGIT|'_')*;
INTEGER:  DIGIT+;
floatnumber: INTEGER? '.' INTEGER*;
number:  '-'? (floatnumber | INTEGER);

prog: stat+ ;

stat: expr ';'?										# printExpr
	| ID '=' expr ';'?								# assign
	| ID '(' ID (',' ID)* ')' '=' expr ';'?			#functionassign
	;

expr: <assoc=right> expr ('^'|'**') expr			# Power
	| expr op=('*'|'/') expr						# MulDiv
	| expr op=('+'|'-') expr						# AddSub
	| number										# float
	| ID '(' expr (',' expr)* ')'					# function
	| ID											# id	
	| '(' expr ')'								# parens
	;

MUL :   '*' ; // assigns token name to '*' used above in grammar
DIV :   '/' ;
ADD :   '+' ;
SUB :   '-' ;
	