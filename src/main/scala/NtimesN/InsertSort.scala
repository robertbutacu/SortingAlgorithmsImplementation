package NtimesN

import scala.annotation.tailrec

/**
  * Created by Robert-PC on 8/29/2017.
  */
trait InsertSort {
  @tailrec
  final def insertSort(input: List[Int], currentPos: Int): List[Int] = {
    def insertElement(input: List[Int], element: Int, currentPos: Int): List[Int] = {
      if (currentPos > 0)
        if (input(currentPos) > element)
          input.slice(0, currentPos) ::: List(element) ::: input.slice(currentPos, input.length)
        else
          insertElement(input, element, currentPos - 1)
      else
        List(element) ::: input
    }

    if (currentPos < input.length)
      {println(input); insertSort(insertElement(input.filter(_ != input(currentPos)), input(currentPos), currentPos - 1), currentPos + 1)}
    else
      input
  }
}
