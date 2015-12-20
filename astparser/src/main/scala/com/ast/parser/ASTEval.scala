package com.ast.parser

import com.ast.functions._

trait ASTEval extends ASTFunctions {
  def eval(expr: Expr,context:Map[String,Double]): Double = expr match {
    case Add(e1: Expr, e2: Expr) => eval(e1,context) + eval(e2,context)
    case Sub(e1: Expr, e2: Expr) =>eval(e1,context) - eval(e2,context)
    case Mul(e1: Expr, e2: Expr) => eval(e1,context) * eval(e2,context)
    case Div(e1: Expr, e2: Expr) => eval(e1,context) / eval(e2,context)
    case Min(e: List[Expr])      => e.map(a => eval(a,context)).reduceLeft(min)
    case Max(e: List[Expr])      => e.map(a => eval(a,context)).reduceLeft(max)
    case Number(e: String)       => e.toDouble
    case Var(varName:String)=> context.get(varName) match {
      case Some(v)=> v
      case None => 0
    }
  }
  def min(e1: Double, e2: Double): Double = if (e1 < e2) e1 else e2
  def max(e1: Double, e2: Double): Double = if (e1 < e2) e2 else e1
}