package lectures.part1basics

object DefaultArgs extends App {

  /**
   * Obs:
   * 1. Pot sa am parametrii default, pentru situatia in care voi
   * apela mereu functia cu valoarea respectiva a parametrului
   * 2. Parametrul avand valoare default NU poate fi primul din
   * lista de parametri pentru ca nu poate fi omis la apelul functiei
   * 3. Putem specifica parametrii prin nume in momentul in care apelam
   * functia si in felul acesta compilatorul stie sa mapeze corect
   * valorile parametrilor
   * 4. Daca specific parametrii prin nume, pot sa ii pasez in orice
   * ordine vreau (nu e nevoie sa pastrez ordinea lor din semnatura functiei)
   */

  def factTailRec(n: Int, acc: Int = 1): Int = {
    if(n <= 1) acc
    else factTailRec(n - 1, acc * n)
  }

  println(factTailRec(4))

  def savePicture(format: String = "jpg", width: Int, height: Int): Unit = println("saving picture")
  //savePicture(800, 600) // o sa dea eroare de compilare
  savePicture(width = 800, 600)
  savePicture(height = 600, width = 800, format = "bmp")
}
