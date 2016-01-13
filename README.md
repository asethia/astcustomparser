<h2>Grammar based AST Tree</h2>

This project is based on Scala, building AST Tree using Scala Combinator. The project supports Max, Min and arthimetic operators like "+"."-","/","*".

The parser accepts input in form as String and creates intermediate representation (IR) and using evaluator parse the result.

The parser grammar is:

exp_function ← expression | function | variable | conditional <br/>
function ← (‘Max’|‘Min’)  (‘(" exp_function ‘,’ ‘)’)* <br/>
conditional ← ifCondition (thenCondition)
ifCondition ← (if|If) (‘(’ exp_function (‘>’ / ‘<’)  exp_function ‘(’)
thenCondition ← (then|Then|THEN) (exp_function)
variable ← (var) (‘(’ [a-zA-Z]+ ‘)’)* <br/>
expression ← term ((‘+’ / ‘-’) term)* <br/>
term ← factor ((‘*’ / ‘/’) factor)* <br/>
factor ← Number (‘(’ expr  ‘)’)* <br/>

This grammar supports Max, Min functions, these functions accepts list of exp_functions. The grammar supports variable defination; that can be define as var(x), var(Test_Var), etc.

The grammar also supports if and then condtional, means if(exp>expr) then expr , etc.

Few of sample example based on above grammar can be:

1. Max(Min(11,11+6),Max(12,6,7*2)) 
2. 2+4-(4*2)
3. (4/2)-(5*2)+ (11-(2+3))
4. Max(var(a_45),var(b),2*15,10+2)
5. if(4<5) then Max(2,10)

The evaluator accepts result of parser and context (as Map object) to get value of variables.   

This can extend with other business oriented and aggregation functions.

Future work: <a href="https://github.com/asethia/retaildsl">Retail DSL in scala</a>
