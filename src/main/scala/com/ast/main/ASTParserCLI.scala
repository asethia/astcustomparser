package com.ast.main


import com.ast.parser._

object ASTParserCLI extends ASTParser with ASTEval {

  def main(args: Array[String]) {
     val context:Map[String,Double]=Map(("a_45",24),("b",20))
    parseAll(exp_function, "Max(Min(11,11+6),Max(12,6,7*2))") match {
      case Success(result, _) => {println("AST :"+result);println("Eval :"+ eval(result,context))}
      case Failure(msg, _)    => println(msg)
      case Error(msg, _)      => println(msg)
    }
    
   parseAll(exp_function, "Max(var(a_45),var(b),2*15,10+2)") match {
      case Success(result, _) => {println("AST :"+result);println("Eval :"+ eval(result,context))}
      case Failure(msg, _)    => println(msg)
      case Error(msg, _)      => println(msg)
    }
  }
}