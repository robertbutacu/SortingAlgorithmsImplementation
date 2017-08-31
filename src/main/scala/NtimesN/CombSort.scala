package NtimesN

import scala.annotation.tailrec

/**
  * Created by Robert-PC on 8/29/2017.
  */
trait CombSort {
  def combSort(input: List[Int]): List[Int] = {
    def getNextGap(currentGap: Int): Int = {
      1.max((currentGap * 10) / 13)
    }

    @tailrec
    def iterate(input: Array[Int], currentPosition: Int, gap: Int, swapped: Boolean): (Array[Int], Boolean) = {
      if (currentPosition < (input.length - gap)) {
        if (input(currentPosition) > input(currentPosition + gap)) {
          val aux = input(currentPosition + gap)
          input(currentPosition + gap) = input(currentPosition)
          input(currentPosition) = aux
          iterate(input, currentPosition + 1, gap, swapped = true)
        } else
          iterate(input,
            currentPosition + 1,
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
