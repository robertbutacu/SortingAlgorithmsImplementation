package NtimesN

/**
  * Created by Robert-PC on 8/29/2017.
  */
trait InsertSort {
  def insertSort(input: List[Int]): List[Int] = {
    def insertElement(input: List[Int], currentPos: Int): List[Int] = {
      input.slice(0, currentPos).filter(_ < input(currentPos)) :::
        List(input(currentPos)) :::
        input.slice(0, currentPos).filter(_ > input(currentPos))
    }

    input.foreach{
      element =>
        insertElement(input, input.indexOf(element))
    }

    input
  }
}
