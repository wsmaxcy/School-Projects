
/* CSci 555: Functional Programming
   Spring 2016, Assignment #1a (Case Classes)
   H. Conrad Cunningham

   Based partially on code from Section 6 of _A Scala Tutorials for
   Java Programmers_, but reimplemented in an object-oriented style in
   2006 and 2008.

123456789012345678901234567890123456789012345678901234567890123456789012345678

*/

/* Expression tree case class hierarchy */

abstract class Tree
case class Sum(l: Tree, r: Tree)  extends Tree  // addition
case class Var(n: String)         extends Tree  // variable (name)
case class Const(v: Double)       extends Tree  // constant (value)


/* Expression Tree operations */

object ExprCase {

  type Environment = String => Double

  // Evaluate the expression t in the environment env
  def eval(t: Tree,env: Environment): Double = t match {
    case Sum(l,r)  => eval(l, env) + eval(r, env)
    case Var(n)    => env(n)
    case Const(v)  => v
  }

  // Determine the derivative of expression t with respect to variable v
  def derive(t: Tree, v: String): Tree = t match {
    case Sum(l,r)  => Sum(derive(l,v), derive(r,v))
    case Var(n) if (v == n) => Const(1)
    case _         => Const(0.0)
  }

  // Simplify expression t by replacing constant subexpressions by a 
  // constant
//def simplify(t: Tree): Tree

  // Main program for testing
  def main(args: Array[String]) {

    val env: Environment = { case "x" => 5 case "y" => 7 }

    println(
    "Begin testing expression tree operations -- Pattern-matching version")

    val c0:  Tree = Const(0.0)
    val c1:  Tree = Const(1.0)
    val c3:  Tree = Const(3.0)
    val c6:  Tree = Const(6.0)
    val c7:  Tree = Const(7.0)
    val cm3: Tree = Const(-3.0)

    println("Expression: " + c0)
    println("Evaluation with x=5, y=7: "  + eval(c0, env))
    println("Derivative relative to x:\n" + derive(c0, "x"))
    println("Derivative relative to y:\n" + derive(c0, "y"))
//  println("Simplification:\n"           + simplify(c0))
    println("")

    println("Expression: "+ cm3)
    println("Evaluation with x=5, y=7: "  + eval(cm3, env))
    println("Derivative relative to x:\n" + derive(cm3, "x"))
    println("Derivative relative to y:\n" + derive(cm3, "y"))
//  println("Simplification:\n"           + simplify(cm3))
    println("")

    val x: Tree = Var("x")
    val y: Tree = Var("y")
    val z: Tree = Var("z")  /* no value in env */

    println("Expression: "                + x)
    println("Evaluation with x=5, y=7: "  + eval(x, env))
    println("Derivative relative to x:\n" + derive(x, "x"))
    println("Derivative relative to y:\n" + derive(x, "y"))
//  println("Simplification:\n"           + simplify(x))
    println("")

    println("Expression: "                + z)
//  Undefined variable.  No provision currently to  handle this.
//  println("Evaluation with x=5, y=7: "  + eval(z, env))
    println("Derivative relative to x:\n" + derive(z, "x"))
    println("Derivative relative to y:\n" + derive(z, "y"))
//  println("Simplification:\n" + simplify(z))
    println("")

    val s0L: Tree = Sum(c0,c3)
    val s0R: Tree = Sum(c3,c0)
    val s1:  Tree = Sum(c7,cm3)
    val s2:  Tree = Sum(c1,y)
    val s3:  Tree = Sum(x,c3)
    val s4:  Tree = Sum(x,y)
    val s5:  Tree = Sum(s1,s0R)
    val s6:  Tree = Sum(Sum(s1,s2),Sum(s1,s4))

    println("Expression: "                + s0L)
    println("Evaluation with x=5, y=7: "  + eval(s0L, env))
    println("Derivative relative to x:\n" + derive(s0L, "x"))
    println("Derivative relative to y:\n" + derive(s0L, "y"))
//  println("Simplification:\n" + simplify(s0L))
    println("")

    println("Expression: "                + s0R)
    println("Evaluation with x=5, y=7: "  + eval(s0R, env))
    println("Derivative relative to x:\n" + derive(s0R, "x"))
    println("Derivative relative to y:\n" + derive(s0R, "y"))
//  println("Simplification:\n" + simplify(s0R))
    println("")

    println("Expression: "                + s1)
    println("Evaluation with x=5, y=7: "  + eval(s1, env))
    println("Derivative relative to x:\n" + derive(s1, "x"))
    println("Derivative relative to y:\n" + derive(s1, "y"))
//  println("Simplification:\n" + simplify(s1))
    println("")

    println("Expression: "                + s2)
    println("Evaluation with x=5, y=7: "  + eval(s2, env))
    println("Derivative relative to x:\n" + derive(s2, "x"))
    println("Derivative relative to y:\n" + derive(s2, "y"))
//  println("Simplification:\n" + simplify(s2))
    println("")

    println("Expression: "                + s3)
    println("Evaluation with x=5, y=7: "  + eval(s3, env))
    println("Derivative relative to x:\n" + derive(s3, "x"))
    println("Derivative relative to y:\n" + derive(s3, "y"))
//  println("Simplification:\n" + simplify(s3))
    println("")

    println("Expression: "                + s4)
    println("Evaluation with x=5, y=7: "  + eval(s4, env))
    println("Derivative relative to x:\n" + derive(s4, "x"))
    println("Derivative relative to y:\n" + derive(s4, "y"))
//  println("Simplification:\n" + simplify(s4))
    println("")

    println("Expression: "                + s5)
    println("Evaluation with x=5, y=7: "  + eval(s5, env))
    println("Derivative relative to x:\n" + derive(s5, "x"))
    println("Derivative relative to y:\n" + derive(s5, "y"))
//  println("Simplification:\n" + simplify(s5))
    println("")

    println("Expression: "                + s6)
    println("Evaluation with x=5, y=7: "  + eval(s6, env))
    println("Derivative relative to x:\n" + derive(s6, "x"))
    println("Derivative relative to y:\n" + derive(s6, "y"))
//  println("Simplification:\n" + simplify(s6))
    println("")

    val exp: Tree = Sum(Sum(x,x),Sum(c7,y))

    println("Expression: " + exp)
    println("Evaluation with x=5, y=7: "  + eval(exp, env))
    println("Derivative relative to x:\n" + derive(exp, "x"))
    println("Derivative relative to y:\n" + derive(exp, "y"))
    println("")
  }
}