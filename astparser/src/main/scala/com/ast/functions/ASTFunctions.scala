package com.ast.functions

/**
 * AST Expression Functions
 */
trait ASTFunctions {
  sealed abstract class Expr
  case class Add(e1: Expr, e2: Expr) extends Expr
  case class Sub(e1: Expr, e2: Expr) extends Expr
  case class Mul(e1: Expr, e2: Expr) extends Expr
  case class Div(e1: Expr, e2: Expr) extends Expr
  case class Number(e: String) extends Expr
  case class Min(e1: List[Expr]) extends Expr
  case class Max(e1: List[Expr]) extends Expr
  case class Var(e1: String) extends Expr
 }