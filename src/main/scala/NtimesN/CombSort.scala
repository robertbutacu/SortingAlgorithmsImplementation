package NtimesN

import scala.annotation.tailrec

/**
  * Created by Robert-PC on 8/29/2017.
  */
object CombSort {
  def combSort(input: List[Int]): List[Int] = {
    def getNextGap(currentGap: Int): Int = {
      1.max((currentGap * 10) / 13)
    }

    @tailrec
    def iterate(input: Array[Int], index: Int, gap: Int, swapped: Boolean): (Array[Int], Boolean) = {
      if (index < (input.length - gap)) {
        if (input(index) > input(index + gap)) {
          val aux = input(index + gap)
          input(index + gap) = input(index)
          input(index) = aux
          iterate(input, index + 1, gap, swapped = true)
        } else
          iterate(input,
            index + 1,
            gap,
            swapped)
      } else {
        (input, swapped)
      }
    }

    @tailrec
    def combSort(input: List[Int], previousGap: Int, swapped: Boolean): List[Int] = {
      if (previousGap != 1 || swapped) {
        val currentGap = getNextGap(previousGap)
        iterate(input.toArray, 0, currentGap, swapped = false) match {
          case (partiallySorted, hasSwapped) => combSort(partiallySorted.toList, getNextGap(currentGap), hasSwapped)
        }
      }
      else
        input
    }

    combSort(input, input.length, swapped = true)
  }
}
