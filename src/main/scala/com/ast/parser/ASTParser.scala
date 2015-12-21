package com.ast.parser

import scala.util.parsing.combinator._

import com.ast.functions._

/**
 * Expression Parser
 */
trait ASTParser extends JavaTokenParsers with ASTFunctions{
  def exp_function: Parser[Expr] = expr | function | variable
  def function = ("Max" ^^^ Max | "Min" ^^^ Min) ~ ("(" ~> repsep(exp_function, ",") <~ ")") ^^ { case f ~ list => f(list) }
  def variable = ("var" ^^^ Var) ~ ("(" ~> ident <~ ")") ^^ { case v ~ n => v(n) }
  def expr: Parser[Expr] = chainl1(term, "+" ^^^ Add | "-" ^^^ Sub)
  def term = chainl1(factor, "*" ^^^ Mul | "/" ^^^ Div)
  def factor = floatingPointNumber ^^ Number | "(" ~> exp_function <~ ")"
}
