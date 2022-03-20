package lectures.part1basics

object Functions extends App {

  def myFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(myFunction("hello", 3))

  def anotherFunction(): Int = 42
  println(anotherFunction())

  /**
   * Obs:
   * 1. In Scala 2, puteam apela si asa: println(anotherFunction)
   * 2. Din Scala 3, nu mai putem face acest lucru
   * - functiile definite folosind paranteze vor fi apelate cu paranteze
   * - functiile definite fara paranteze vor fi apelate fara paranteze
   * 3. Tipul de return al functiei poate fi inferat
   */

  def recursiveFunction(str: String, num: Int): String = {
    if(num == 1) str
    else str + recursiveFunction(str, num - 1);
  }

  println(recursiveFunction("hello", 3))

  /**
   * Obs:
   * 1. Atunci cand avem nevoie sa facem un loop (while, for, etc), putem
   * simula acest lucru in FP prin intermediul unei functii recursive
   * 2. Daca functia e recursiva, tipul de return al functiei nu poate
   * fi inferat de catre compilator
   */

  def aFunctionWithSideEffects(str: String): Unit = println(str)

  def aBigFunction(num: Int) = {
    def aSmallerFunction(a: Int, b: Int) = a+b

    aSmallerFunction(num, num - 1)
  }

  /**
   * Obs:
   * 1. Pot sa definesc functii auxiliare intr-un bloc de cod
   */

  /**
   * Exercitii:
   * 1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old."
   * 2. Factorial function 1 * 2 * 3 ... * n
   * 3. A Fibonacci function: f(1) = 1, f(2) = 1, f(n) = f(n-2) + f(n-1)
   * 4. A function which tests if a number is prime
   */

  def greetingFunction(name: String, age: Int): String = {
    "Hi, my name is " + name + " and I am " + age + " years old."
  }
  println(greetingFunction("Mihai", 24))

  def factorialFunction(num: Int): Int = {
    if(num <= 0) 1
    else num * factorialFunction(num - 1)
  }
  println(factorialFunction(3))

  def fibonacciFunction(num: Int): Int = {
    if(num <= 2) 1
    else fibonacciFunction(num - 2) + fibonacciFunction(num - 1)
  }
  println(fibonacciFunction(5))

  def isPrimeFunction(num: Int): Boolean = {
    def isPrimeUntil(limit: Int): Boolean = {
      if(limit <= 1) true
      else (num % limit != 0) && isPrimeUntil(limit - 1)
    }
    isPrimeUntil(num / 2)
  }
  println(isPrimeFunction(11))
}
