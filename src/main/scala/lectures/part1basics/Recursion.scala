package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorialFunction(num: Int): Int = {
    if(num <= 0) 1
    else {
        println("Computing factorial of " + num + " - I first need factorial of " + (num - 1))
        val result = num * factorialFunction(num - 1)
        println("Computed factorial of " + num)

        result
      }
    }

  println(factorialFunction(5))


  /**
   * Obs:
   * 1. Implementarea clasica e ineficienta pentru un numar mare de iteratii -> va cauza stack overflow
   * 2. De aceea, e nevoie de o implementare pur functionala - calcularea rezultatelor intermediare cu
   * ajutorul unui acumulator
   * 3. In felul asta, nu se va crea cate un stack frame, pentru fiecare apel recursiv al functiei,
   * ci se va folosi acelasi stack frame -> TAIL RECURSION = use recursive call as LAST expression
   */

  def anotherFactorial(num: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, acc: BigInt): BigInt = {
      if(x <= 1) acc
      else factHelper(x - 1, x * acc)
    }

    factHelper(num, 1)
  }

  println(anotherFactorial(5000))

  /**
   * Exercitii:
   * 1. Concatenate a string n times.
   * 2. Check if a number is prime.
   * 3. Fibonacci function.
   */

  def concatStringNTimes(str: String, num: Int): String = {
    def concatHelper(str: String, num: Int, acc: String): String = {
      if(num == 0) acc
      else concatHelper(str, num - 1, acc + str)
    }
    concatHelper(str, num, "")
  }

  println(concatStringNTimes("hello", 3))

  def isPrime(n: Int): Boolean = {
    def isPrimeHelper(limit: Int, isStillPrime: Boolean): Boolean = {
      if(!isStillPrime) false
      else if(limit <= 1) true
      else isPrimeHelper(limit - 1, (n % limit != 0) && isStillPrime)
    }
    isPrimeHelper(n / 2, true)
  }

  println(isPrime(5))
  println(isPrime(9))

  def fibonacciTailRecursive(num: Int): Int = {
    def fibonacciHelper(num: Int, acc1: Int, acc2: Int): Int = {
      if(num <= 2) acc1
      else fibonacciHelper(num - 2, acc1, acc2) + fibonacciHelper(num - 1, acc2, acc1)
    }
    fibonacciHelper(num, 1, 1)
  }

  println(fibonacciTailRecursive(5))
}
