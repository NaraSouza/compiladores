grammar grammarMinijava;

goal : mainClass ( classDeclaration )* EOF;

mainClass : 'class' identifier '{' 'public' 'static' 'void' 'main' '(' 'String' '[' ']' identifier ')' '{' statement '}'
 '}';

classDeclaration : 'class' identifier ( 'extends' identifier )? '{' ( varDeclaration )* ( methodDeclaration )* '}';

varDeclaration : type identifier ';';

methodDeclaration : 'public' type identifier '(' ( type identifier ( ',' type identifier )* )? ')' '{' ( varDeclaration )*
 ( statement )* 'return' expression ';' '}';

type : 'int' '[' ']'
|	'boolean'
|	'int'
|	identifier;

statement : '{' ( statement )* '}'
|	'if' '(' expression ')' statement 'else' statement
|	'while' '(' expression ')' statement
|	'System.out.println' '(' expression ')' ';'
|	identifier '=' expression ';'
|	identifier '[' expression ']' '=' expression ';';

expression	:	expression ( '&&' | '<' | '+' | '-' | '*' ) expression
|	expression '[' expression ']'
|	expression '.' 'length'
|	expression '.' identifier '(' ( expression ( ',' expression )* )? ')'
|	integer_literal
|	'true'
|	'false'
|	identifier
|	'this'
|	'new' 'int' '[' expression ']'
|	'new' identifier '(' ')'
|	'!' expression
|	'(' expression ')';

identifier: Identifier;

integer_literal: Integer_literal;

Identifier : ([A-Za-z] | [_])(([A-Za-z] | [0-9]) | [_])*;

Integer_literal : [0-9]+;

Comment: '/*' .*? '*/' -> skip;

Comment_in_line: '//' ~[\r\n]* -> skip;

Whitespace: [ \t\f\r\n] -> skip;