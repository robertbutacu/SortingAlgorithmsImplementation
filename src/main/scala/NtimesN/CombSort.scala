package NtimesN

import scala.annotation.tailrec

/**
  * Created by Robert-PC on 8/29/2017.
  */
trait CombSort {
  def combsort(input: List[Int]): List[Int] = {
    def getNextGap(currentGap: Int): Int = {
      1.max((currentGap * 10) / 13)
    }

    @tailrec
    def iterate(input: Array[Int], currentPosition: Int, gap: Int, swapped: Boolean): (Array[Int], Boolean) = {
      currentPosition < (input.length - gap) match {
        case true =>
          if (input(currentPosition) > input(currentPosition + gap)){
            println("Swapping " + input(currentPosition) + " with " + input(currentPosition + gap))
            val aux = input(currentPosition + gap)
            input(currentPosition + gap) = input(currentPosition)
            input(currentPosition) = aux
            iterate(input, currentPosition + 1, gap, swapped = true)
          }
          else
            iterate(input,
              currentPosition + 1,
              gap,
              swapped)
        case false => (input, swapped)
      }
    }

    @tailrec
    def combsort(input: List[Int], currentGap: Int, swapped: Boolean): List[Int] = {
      if (currentGap != 1 || swapped) {
        iterate(input.toArray, 0, currentGap, false) match {
          case (partiallySorted, hasSwapped) => combsort(partiallySorted.toList, getNextGap(currentGap), hasSwapped)
        }
      }
      else
        input
    }
    combsort(input, input.length, swapped = true)
  }
}
