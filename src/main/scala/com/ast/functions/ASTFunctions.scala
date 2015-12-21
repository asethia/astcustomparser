package com.ast.functions

/**
 * Hierarchical case class to deinfe AST tree nodes
 */
trait ASTFunctions {
  sealed abstract class Expr
  case class Add(e1: Expr, e2: Expr) extends Expr
  case class Sub(e1: Expr, e2: Expr) extends Expr
  case class Mul(e1: Expr, e2: Expr) extends Expr
  case class Div(e1: Expr, e2: Expr) extends Expr
  case class Number(e: String) extends Expr
  //Minimum function
  case class Min(e1: List[Expr]) extends Expr
  //Maximum function
  case class Max(e1: List[Expr]) extends Expr
  //varibale defination
  case class Var(e1: String) extends Expr
 }
