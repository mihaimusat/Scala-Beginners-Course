package lectures.part2oop

object OOBasics extends App {

  val person = new Person("Mihai", 24)
  println(person.age)
  println(person.x)
  person.greet("Daniel")
  person.greet()

  val writer = new Writer("Ion", "Creanga", 1840)
  val writer2 = new Writer("Mihai", "Eminescu", 1828)
  val novel = new Novel("Amintiri din copilarie", 1872, writer)

  writer.fullName()
  novel.authorAge()
  novel.isWrittenBy(writer2)
  val novel2 = novel.copy(1882)
  novel2.isWrittenBy(writer)

  val counter = new Counter(2)
  val incCounter = counter.increment()
  incCounter.printValue()
  val decCounter = counter.decrement()
  decCounter.printValue()
  val incCounterWithAmt = counter.incrementWithAmt(2)
  incCounterWithAmt.printValue()
  val decCounterWithAmt = counter.decrementWithAmt(2)
  decCounterWithAmt.printValue()

}

/**
 * Obs:
 * 1. Nu pot sa accesez name sau age ca si membri ai clasei Person,
 * ci acestia sunt parametri ai clasei respective
 * 2. Pentru a converti un parametru intr-un membru al clasei, se
 * foloseste keyword-ul "val" inaintea definirii parametrului
 * 3. In corpul unei clase, pot defini atat membri prin intermediul
 * keyword-ului "val" sau "var", cat si expresii, metode sau clase interne
 * 4. In practica, nu am nevoie de mai multi constructori deoarece pot sa setez
 * anumite valori default pentru parametrii clasei
 */

/**
 * Exercitii:
 * 1. De implementat o clasa Novel si o clasa Writer
 * - Writer trebuie sa aiba ca atribute: first name, surname si year of birth
 * - Writer trebuie sa aiba o metoda fullname, care concateneaza cele doua nume
 * - Novel trebuie sa aiba ca atribute: name, year of release si author de tip Writer
 * - Novel trebuie sa aiba o metoda authorAge: intoarce varsta autorului la data lansarii cartii
 * + isWrittenBy(author) + copy(new year of release)
 *
 * 2. De implementat clasa Counter
 * - primeste ca valoare un intreg
 * - are o metoda care intoarce valoarea curenta a intregului
 * - are o metoda pentru increment/decrement care intoarce o instanta noua a counter-ului
 * - overload increment/decrement cu o anumita valoare si intoarce o noua instanta a counter-ului
 */

//constructor
class Person(name: String, val age: Int) {

  //fields
  val x = 2

  //methods
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  //overloading
  def greet(): Unit = println(s"Hi, I am $name")

  //multiple constructors
  def this(name: String) = this(name, 0)
}

class Writer(firstName: String, lastName: String, val birthYear: Int) {

  def fullName(): Unit = println(firstName + " " + lastName)
}

class Novel(name: String, releaseYear: Int, author: Writer) {

  def authorAge(): Unit = println(releaseYear - author.birthYear)

  def isWrittenBy(author: Writer): Unit = println(author == this.author)

  def copy(newReleaseYear: Int) = new Novel(name, newReleaseYear, author)
}

class Counter(value: Int) {

  def printValue(): Unit = println(value)

  //immutability
  def increment() = new Counter(value + 1)

  def decrement() = new Counter(value - 1)

  def incrementWithAmt(amount: Int): Counter = {
    if(amount <= 0) this
    else increment().incrementWithAmt(amount - 1)
  }

  def decrementWithAmt(amount: Int): Counter = {
    if(amount <= 0) this
    else decrement().decrementWithAmt(amount - 1)
  }
}





