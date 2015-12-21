package com.ast.parser

import scala.util.parsing.combinator._

import com.ast.functions._

/**
 * Expression Parser
 */
trait ASTParser extends JavaTokenParsers with ASTFunctions{
  def exp_function: Parser[Expr] = expr | function | variable | conditional
  //functions
  def function = ("Max" ^^^ Max | "Min" ^^^ Min) ~ ("(" ~> repsep(exp_function, ",") <~ ")") ^^ { case f ~ list => f(list) }
  //variable
  def variable = ("var" ^^^ Var) ~ ("(" ~> ident <~ ")") ^^ { case v ~ n => v(n) }
  //condition
  def conditional = ifCondition ~ thenCondition  ^^ { case ifcond ~ thenExp  => ifcond.copy(thenExp=thenExp)}
  //if condition
  def ifCondition = "(if|If)" ~ "(" ~> exp_function  ~ (">" | "<") ~ exp_function <~ ")"  ^^ { case e1 ~ cond ~ e2  => IfCondition(e1, e2, cond,null) }
  //then result of if condition
  def thenCondition= "(then|THEN|Then)" ~ (exp_function) ^^ {case then ~ expr=>expr} 
  //expr
  def expr: Parser[Expr] = chainl1(term, "+" ^^^ Add | "-" ^^^ Sub)
  def term = chainl1(factor, "*" ^^^ Mul | "/" ^^^ Div)
  def factor = floatingPointNumber ^^ Number | "(" ~> exp_function <~ ")"
}
