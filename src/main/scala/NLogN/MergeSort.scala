package NLogN

import scala.annotation.tailrec

/**
  * Created by Robert-PC on 8/29/2017.
  */
/**
  * There are 2 important points when memorising mergesort:
  *   1. merge() receiving 2 ordered lists and "merging" them
  *     Ex: 5 8 32 40         4 9 35 50
  *             4 5 8 9 32 35 40 50
  *   Of course, you almost never get 2 sorted arrays if you were to split a big one.
  *   2. recursively split the list in half until there is only 1 element left, and then start sorting.
  *     Ex: 9 4 8 7 1 5 => 6 elements, first two elements will be sorted first => 4 9, then 7 8, then 1 5.
  *       Following that, 4 9 and 7 8 will be sorted => 4 7 8 9, and in the end, with 1 5 => 1 4 5 6 7 8.
  *
  *   Very good video : https://www.youtube.com/watch?v=EeQ8pwjQxTM  .
  */

trait MergeSort {
  def mergeSort(input: List[Int]): List[Int] = {
    @tailrec
    def merge(first: List[Int], second: List[Int], sortedArray: List[Int]): List[Int] = (first, second) match {
      case (_, Nil)                   => sortedArray ::: first
      case (Nil, _)                   => sortedArray ::: second
      case (x :: xsTail, y :: ysTail) =>
        if (x < y)
          merge(xsTail, second, sortedArray :+ x)
        else
          merge(first, ysTail, sortedArray :+ y)
    }
    if (input.length < 2)
      input
    else {
      val mid = input.length / 2
      merge(mergeSort(input.slice(0, mid)), mergeSort(input.slice(mid, input.length)), List())
    }
  }
}
