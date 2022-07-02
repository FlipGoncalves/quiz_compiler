grammar Quizz;

/**
* Grammar rules
*/

program: statement* EOF;

expr returns[VType tp, String var = null]: methods {$tp = $methods.tp;} 
    | operation {$tp = $operation.tp;}
    | attribute {$tp = $attribute.tp;}
    ;
statement: assignment | cycle | condition | expr | output | breakOperation;
/**
* Assignments
*/

assignment: VarType ID '=' expr                                         #DeclAssign
    | ID '=' expr                                                       #Assign
    | VarType ID                                                        #Decl
    ;

quiz: 'Quiz(' expr (',' expr)? ')';
question: 'Question(' (expr ',' expr ',' expr ',' expr)? ')';
text: String                                                            #TextString
    | 'Text(' expr ')'                                                  #TextExpr
    ;
number returns[VType tp]:
    value {$tp = $value.tp;}                                            #NumberValue
    | 'Number(' expr ')' {$tp = $expr.tp;}                              #NumberExpr
    ;
table returns[TableVType tp = new TableVType();]: '{' (VarType ','?)? ((expr ',')* expr)? '}';
bquest: 'import(' fname=String ')';

value returns[NumberVType tp]:
    Int {$tp = new IntegerVType();}                                     #NumInt
    | Double {$tp = new DoubleVType();}                                 #NumDouble
    ;

type returns [TypeVType tp]:
    'MultipleChoice(' (expr ',' expr)? ')' {$tp = new MultipleChoiceVType();}       #MultipleChoice
    | 'Matching(' (expr ',' expr ',' expr)? ')' {$tp = new MatchingVType();}        #Matching
    | 'ShortAnswer(' (expr ',' expr)? ')' {$tp = new ShortAnswerVType();}           #ShortAnswer
    | 'NumericAnswer(' expr? ')' {$tp = new NumericAnswerVType();}                  #NumericAnswer
    | 'Essay(' expr? ')' {$tp = new EssayVType();}                                  #Essay
    ;

attribute returns[VType tp, String var = null]: text {$tp = new TextVType();}
    | number {$tp = $number.tp;}
    | table {$tp = $table.tp;}
    | bquest {$tp = new BQuestVType();}
    | input {$tp = new TextVType();}
    | quiz {$tp = new QuizVType();}
    | question {$tp = new QuestionVType();}
    | type {$tp = $type.tp;}
    | shuffle {$tp = $shuffle.tp;}
    | ID {$tp = new NoneVType();}
    ;

/**
* Unary operators
*/

shuffle returns[TableVType tp = new TableVType();]: 'Shuffle' '[' expr ']';

input: 'input(' expr ')';
output: 'output(' expr ')';

/**
* Normal control flow operators
*/

cycle: 'for' ID 'from' expr 'to' expr 'do' statement* 'end'             #NumericIteration
    | 'for' ID 'in' expr 'do' statement* 'end'                          #TableIteration
    ;

condition: 'if' logic 'do' statement* 'end';

breakOperation: BreakOperator;

/**
* Binary operators
*/

operation returns[VType tp = null, String var = null]:
        '(' operation ')'                                               #ParenthesisOper
        | sign=('+'|'-') operation                                      #SignOper
        | <assoc=right> operation op='^' operation                      #Exponent
        | operation op=('*' | '/' | '%'|'//') operation                 #MulDivMod
        | operation op=('+' | '-') operation                            #AddSubtract      
        | attribute                                                     #Item
        ;

logic returns[String var = null]: '(' logic ')'                         #ParenthesisCond
        | 'not' logic                                                   #NotCond
        | logic op=('and'|'or') logic                                   #CondComp
        | expr op=('=='|'!='|'<'|'>'|'<='|'>='|'contains') expr         #VarComp
        ;

/**
* Methods
*/

methods returns[VType tp = null, String var = null]:
    methods MethodTypes name=ID? '(' ((expr ',')* expr)? ')'            #Method
    | singleId=ID                                                       #SingleId
    ;

/**
* Lexer tokens
*/
BreakOperator: 'break';
VarType: ('Text'|'Number'|'Quiz'|'Question'|'BQuest'|'Table'|'Type');
ID: [a-zA-Z_][a-zA-Z_0-9]*;
String: '"'.*?'"';
Int: [0-9]+;
Double: [0-9]+'.'[0-9]+;

// Set and object operations
MethodTypes: ('>>'|'<<'|'<+'|'<-'|'::');

// Trash
WS:[ \t\r\n]+->skip;
LINE_COMMENT : '//' .*? NEWLINE  -> skip;
FULL_COMMENT: '//(' .*? ')//'? -> skip;
NEWLINE:  '\r'? '\n' -> skip; 
