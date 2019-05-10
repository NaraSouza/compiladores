grammar grammarMinijava;

goal : MainClass ( ClassDeclaration )* EOF;

MainClass : 'class' Identifier '{' 'public' 'static' 'void' 'main' '(' 'String' '[' ']' Identifier ')' '{' Statement '}'
 '}';

ClassDeclarationv : 'class' Identifier ( 'extends' Identifier )? '{' ( VarDeclaration )* ( MethodDeclaration )* '}';

VarDeclaration : Type Identifier ';';

MethodDeclaration : 'public' Type Identifier '(' ( Type Identifier ( ',' Type Identifier )* )? ')' '{' ( VarDeclaration )*
 ( Statement )* 'return' Expression ';' '}';

Type : 'int' '[' ']'
|	'boolean'
|	'int'
|	Identifier;

Statement : '{' ( Statement )* '}'
|	'if' '(' Expression ')' Statement 'else' Statement
|	'while' '(' Expression ')' Statement
|	'System.out.println' '(' Expression ')' ';'
|	Identifier '=' Expression ';'
|	Identifier '[' Expression ']' '=' Expression ';';

Expression : Expr
|	INTEGER_LITERAL Expr
|	'true' Expr
|	'false' Expr
|	Identifier Expr
|	'this' Expr
|	'new' 'int' '[' Expression ']' Expr
|	'new' Identifier '(' ')' Expr
|	'!' Expression Expr
|	'(' Expression ')' Expr;

Expr : ( '&&' | '<' | '+' | '-' | '*' ) Expression Expr
|   '[' Expression ']' Expr
|	'.' 'length' Expr
|   '.' Identifier '(' ( Expression ( ',' Expression )* )? ')' Expr
|   ;

Identifier : ([A-Za-z] | [_])(([A-Za-z] | [0-9]) | [_])*;

INTEGER_LITERAL : [0-9]+;