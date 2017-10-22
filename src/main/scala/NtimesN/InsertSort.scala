package NtimesN

import scala.annotation.tailrec

/**
  * Created by Robert-PC on 8/29/2017.
  */
object InsertSort {
  @tailrec
  final def insertSort(input: List[Int], currentPos: Int): List[Int] = {
    def insertElement(input: List[Int], currentPos: Int): List[Int] = {
      input.slice(0, currentPos).filter(_ < input(currentPos)) :::
        List(input(currentPos)) :::
        input.slice(0, currentPos).filter(_ > input(currentPos)) :::
        input.slice(currentPos + 1, input.length)
    }

    if(currentPos < input.length)
      insertSort(insertElement(input, currentPos), currentPos + 1)
    else
      input
  }
}
