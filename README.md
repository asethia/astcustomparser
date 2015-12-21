This project is based on Scala, building AST Tree using Scala Combinator. The project supports Max, Min and arthimetic operators like "+"."-","/","*".

The parser accepts input in form as String and creates intermediate representation (IR) and using evaluator parse the result.

The parser grammer is:

exp_function ← expr | function | variable  <br/>
function ← (‘Max’|‘Min’)  (‘(" exp_function ‘,’ ‘)’)* <br/>
variable ← (var) (‘(‘ [a-zA-Z]+ ‘)’)* <br/>
Expression ← Term ((‘+’ / ‘-’) Term)* <br/>
Term ← Factor ((‘*’ / ‘/’) Factor)* <br/>
Factor ← Number (‘(’ expr  ‘)’)* <br/>

This grammer supports Max, Min functions, these functions accepts list of exp_functions. The grammer supports variable defination; that can be define as var(x), var(Test_Var), etc.

Few of sample example based on above grammer can be:

1. Max(Min(11,11+6),Max(12,6,7*2)) 
2. 2+4-(4*2)
3. (4/2)-(5*2)+ (11-(2+3))
4. Max(var(a_45),var(b),2*15,10+2)

The evaluator accepts result of parser and context (as Map object) to get value of variables.   
