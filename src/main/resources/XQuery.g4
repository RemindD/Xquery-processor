grammar XQuery;

// XQuery

query
    : varname                                               #xqvar
    | sentence                                              #xqstring
    | ap                                                    #xqap
    | '(' query ')'                                         #xqparen
    | query ',' query                                       #xqconcat
    | query '/' rp                                          #xqslash
    | query  '//' rp                                        #xqdoubleslash
    | '<' string '>' '{' query '}' '</' string '>'          #xqtag
    | 'for' flwr                                            #xqflwr
    | letClause query                                       #xqlet
;

flwr
    :   varname 'in' query (lwr | (',' flwr))
;

lwr
    :   letClause? whereClause? returnClause
;
letClause
    : 'let' varname ':=' query (',' varname ':=' query )
;

whereClause : 'where' cond;

returnClause
    : 'return' query
;

ap
    : ('doc('|'document(') sentence ')' '/'  rp #apslash
    | ('doc('|'document(') sentence ')' '//' rp #apdoubleslash
;

rp
    : string                    #rptag
    | '*'                       #rpchild
    | '.'                       #rpself
    | '..'                      #rpparent
    | 'text()'                  #rptext
    | '@' string                #rpattr
    | '(' rp ')'                #rpparen
    | rp '/' rp                 #rpslash
    | rp '//' rp                #rpdoubleslash
    | rp '['  f ']'             #rpfilter
    | rp ',' rp                 #rpcancat
;

f
    : rp                                    #fltrp
    | rp ('=' | 'eq') rp                    #fltrpvaleq
    | rp ('==' | 'is') rp                   #fltrpeq
    | '(' f ')'                             #fltparen
    | f 'and' f                             #fltand
    | f 'or' f                              #fltor
    | 'not' f                               #fltnot
;

varname: Var;
sentence: StringLiteral;
string: StringConstant;


cond
    : query ('='|'eq') query           #condvaleq
    | query ('=='|'is') query          #condeq
    | 'empty' '(' query ')'            #condempty
    | 'some' varname 'in' query (',' varname 'in' query)* 'satisfies' cond  #condexist
    | '(' cond ')'                     #condparen
    | cond 'and' cond                  #condand
    | cond 'or' cond                   #condor
    | 'not' cond                       #condnot
;

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

WS : [ \t\r\n]+ -> skip ;



