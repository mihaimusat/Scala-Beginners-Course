package lectures.part1basics

object ValuesVariablesTypes extends App {

  val x: Int = 42
  println(x)

  val str: String = "hello"
  println(str)

  val flag: Boolean = true
  println(flag)

  val ch: Char = 'a'
  println(ch)

  val shortVal: Short = 777
  println(shortVal)

  val longVal: Long = 4352352634242L
  println(longVal)

  val floatVal: Float = 2.0f
  println(floatVal)

  val doubleVal: Double = 3.14
  println(doubleVal)

  /**
   * Obs:
   * 1. pentru values, se poate infera tipul la compile time (e.g. val x = 42 nu va da eroare de compilare)
   * 2. values sunt imutabile (e.g. nu pot sa fac o reasignare de tipul x = 2)
   */

  var firstVar: Int = 2
  firstVar = 5
  println(firstVar)

  /**
   * Obs:
   * 1. variables isi pot modifica valoarea pe parcursul executiei programului (in FP, se numesc side effects)
   */
}
