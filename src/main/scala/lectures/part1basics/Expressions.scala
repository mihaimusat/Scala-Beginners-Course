package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2
  println(x)

  println(2 + 3 * 4)

  println(x == 1)

  println(!(x == 1))

  /**
   * Obs:
   * 1. Expresiile sunt evaluate la o anumita valoare si au un tip (e.g. x = 3 si are tipul Int)
   * 2. Tipuri de expresii suportate
   * - matematice: +, -, *, /
   * - bitwise: &, |, ^, <<, >>, >>> (right shift with zero extension)
   * - comparatii: ==, !=, <, <=, >, >=
   * - logica: !, &&, ||
   */

  var y = 2
  y += 3 //acesta e un side effect
  println(y)

  /**
   * Obs:
   * 1. Exista o diferenta intre instructiuni si expresii
   * - instructiuni -> se refera la ce ii spunem compilatorului sa execute
   * - expresii -> ma intereseaza sa obtin o valoare, nu sa setez o valoare
   * 2. Totul in Scala este o EXPRESIE -> nu e ok sa scriu loops ca in C, Java, etc
   */

  val aCondition = true
  val aConditionedValue = if(aCondition) 3 else 5 //IF expression, not instruction -> can be printed
  println(if(aCondition) 3 else 5)
  println(aConditionedValue)

  val aWeirdValue = (y = 10)
  println(aWeirdValue)

  /**
   * Obs:
   * 1. Exista un tip special numit Unit, care este echivalent cu void
   * 2. Acesta are o singura valoare posibila: () si se obtine prin side effects
   * - ex de side effects: println(), reasignare, while loops
   * 3. Un side effect este o expresie care are tipul Unit -> sunt un fel de echivalent
   * al instructiunilor din programarea imperativa
   */

  val aCodeBlock = {
    val one = 1
    val two = one + 1

    if(two > 1) "hello" else "goodbye"
  }
  println(aCodeBlock)

  /**
   * Obs:
   * 1. Un bloc de cod este tot o expresie
   * 2. Tipul si valoarea blocului de cod sunt aceleasi cu ultima expresie din blocul de cod
   * 3. Valorile/variabilele declarate in blocul de cod NU sunt vizibile si in exterior
   */

  /**
   * Exercitii:
   * 1. Care e diferenta dintre "hello world" si println("hello world") ?
   * - prima este o expresie de tip String si a doua este o expresie de tip Unit
   * 2. val someValue = {
   *    3 < 4
   * }
   * Care este tipul si valoarea pentru someValue ?
   * - tipul este Boolean si valoarea este true
   * 3. val someOtherValue = {
   *    if(someValue) 234 else 567
   *    42
   * }
   * Care este tipul si valoarea pentru someOtherValue ?
   * - tipul este Int, deoarece ultima expresie intoarce 42 si valoarea este 42
   */

  val someValue = {
    3 < 4
  }
  println(someValue)

  val someOtherValue = {
    if(someValue) 234 else 567
    42
  }
  println(someOtherValue)

}
