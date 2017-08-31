package NtimesN

import scala.annotation.tailrec

/**
  * Created by Robert-PC on 8/29/2017.
  */
trait BubbleSort {
  // for some reason, not sorting it reversed and then reversing it in the right way at the end,
  // causes the sorting to take about 10-20 times longer
  def bubbleSort(xs: List[Int], index: Int): List[Int] = {
    @tailrec
    def bubbleSortInnerLoop(xs: List[Int], partiallySortedArray: List[Int]): List[Int] = {
      xs match {
        case Nil            => partiallySortedArray.reverse
        case x :: Nil       => (x +: partiallySortedArray).reverse
        case x :: y :: tail => bubbleSortInnerLoop(List(x.max(y)) ::: tail, List(x.min(y)) ::: partiallySortedArray)
      }
    }
    if (index == xs.length)
      xs
    else
      bubbleSort(bubbleSortInnerLoop(xs, List()), index + 1)
  }
}
