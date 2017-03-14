grammar Join;

//Join

query
    : 'for' varname 'in' path (',' varname 'in' path)* ('where' cond)? 'return' ret
;

path
    : ('doc(' sentence ')'| varname ) (sep string)* (sep 'text()')?
;

sep : '/' | '//';

ret
    : varname
    | ret ',' ret
    | '<' string '>' ret '</' string '>'
    | path
    | '{' ret '}'
;

cond
    : varname ('eq' | '=') varorsentence ('and' varname ('eq' | '=') varorsentence)*
;

varorsentence: sentence | varname;

varname: Var;
string: StringConstant;
sentence: StringLiteral;

fragment
Letter
    : [a-zA-Z_]
;
fragment
LetterOrDigit
    : [a-zA-Z0-9_-]
;

StringLiteral
    :'\"' ~[\"\\@]+? '\"'
;

StringConstant: Letter LetterOrDigit*;

Var: '$' StringConstant;

WS : [ \t\r\n]+ -> skip;