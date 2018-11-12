grammar Grammar;

WS: [ \t]+ -> skip;

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];

LOG2 : 'log2' | 'ld' | 'lb' ;
LN:	   'ln' | 'logE';
LOG:   'log';

ID: LETTER (LETTER|DIGIT|'_')*;
INTEGER:  DIGIT+;
floatnumber: INTEGER? '.' INTEGER*;
number:  '-'? (floatnumber | INTEGER);
newnumber: number ('e' ('+' | '-') number)?;

prog: stat+;

stat: expr ';'?								# printExpr
	| ID '=' expr ';'?						# assign
	| ID '(' ID (',' ID)* ')' '=' expr ';'?	# functionassign
	;
	
othermathfunction:  LOG2 '(' expr ')'
				 |  LN '(' expr ')'
				 |  LOG '(' expr ')';

expr: <assoc=right> expr ('^'|'**') expr			# Power
	| expr op=('*'|'/') expr						# MulDiv
	| expr op=('+'|'-') expr						# AddSub
	| newnumber										# float
	| othermathfunction								# mathfunc
	| ID '(' expr (',' expr)* ')'					# function	
	| ID											# id	
	| SUB? '(' expr ')'								# parens
	| ')'											# wrongparens
	;

MUL : '*' ; // assigns token name to '*' used above in grammar
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;



	