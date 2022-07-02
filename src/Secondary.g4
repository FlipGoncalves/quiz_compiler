grammar Secondary;

program: expr* EOF;

expr: '{' question* '}';

question: '{'
    'tema' theme=String
    'enunciado' head=String
    'dificuldade' diff=Dif
    'tipo' type=String
    ('palavras-chave' '[' (pal (',' pal)* )? ']')?
    ('opcoes' '{' (opt (',' opt)*)? '}')?
 '}';

pal: String | Int;
opt: String | '[' (String (',' String)*)? ']';

Dif: [1-3];
Int: [0-9]+;
String: QUOTE .*? QUOTE;
QUOTE: ('\''|'"');
WS: [ \t\r\n]+->skip;
LINE_COMMENT : '//' .*? NEWLINE  -> skip;
FULL_COMMENT: '//(' .*? ')//' -> skip;
NEWLINE:  '\r'? '\n' -> skip;
