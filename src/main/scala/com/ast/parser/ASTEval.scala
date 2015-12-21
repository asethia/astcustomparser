package com.ast.parser

import com.ast.functions._

/**
 * Evaluate hierarchy of AST Tree nodes recursive way
*/
trait ASTEval extends ASTFunctions {
  def eval(expr: Expr,context:Map[String,Double]): Double = expr match {
    //add two expression
    case Add(e1: Expr, e2: Expr) => eval(e1,context) + eval(e2,context)
    //subtract two expression
    case Sub(e1: Expr, e2: Expr) =>eval(e1,context) - eval(e2,context)
    //mul two expression
    case Mul(e1: Expr, e2: Expr) => eval(e1,context) * eval(e2,context)
    //division two expression
    case Div(e1: Expr, e2: Expr) => eval(e1,context) / eval(e2,context)
    //find minimum from list of expression
    case Min(e: List[Expr])      => e.map(a => eval(a,context)).reduceLeft(min)
    //find maximum from list of expression
    case Max(e: List[Expr])      => e.map(a => eval(a,context)).reduceLeft(max)
    //convert expression to double if type is Number
    case Number(e: String)       => e.toDouble
    //if condition 
    case IfCondition(e1: Expr,e2:Expr,cond:String,thenExp:Expr)      => cond match {
      case ">"  => if(eval(e1,context)>eval(e2,context)) eval(thenExp,context) else 0
      case "<"  => if(eval(e1,context)<eval(e2,context)) eval(thenExp,context) else 0
    }
    //get variable value form the context
    case Var(varName:String)=> context.get(varName) match {
      case Some(v)=> v
      case None => 0
    }
  }
  //find minimum between two double numbers
  def min(e1: Double, e2: Double): Double = if (e1 < e2) e1 else e2
  //find maximum between two double numbers
  def max(e1: Double, e2: Double): Double = if (e1 < e2) e2 else e1
}
