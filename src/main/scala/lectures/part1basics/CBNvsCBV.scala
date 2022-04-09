package lectures.part1basics

object CBNvsCBV extends App {

  /**
   * Obs:
   * 1. Apelarea unei functii by value inseamna ca valoarea parametrului este
   * evaluata inainte de executia functiei si inlocuita in corpul functiei
   * 2. Operatorul "=>" intarzie evaluarea valorii parametrului pana in momentul in care
   * este folosit in corpul functiei
   * 3. Apelarea unei functii by name inseamna ca fiecare aparitie a parametrului este
   * inlocuita si evaluata strict in corpul functiei -> util in lazy streams
   */

  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //printFirst(infinite(), 34) // o sa dea stack overflow
  printFirst(34, infinite()) // nu o sa dea stack overflow

}
