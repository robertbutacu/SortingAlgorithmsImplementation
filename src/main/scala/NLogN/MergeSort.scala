package NLogN

import scala.annotation.tailrec

/**
  * Created by Robert-PC on 8/29/2017.
  */
trait MergeSort {
  def mergesort(xs: List[Int]): List[Int] = {
    @tailrec
    def merge(xs: List[Int], ys: List[Int], sortedArray: List[Int]): List[Int] = (xs, ys) match {
      case (_, Nil)          => sortedArray ::: xs
      case (Nil, _)          => sortedArray ::: ys
      case (x :: xsTail, y :: ysTail) =>
        if (x < y)
          merge(xsTail, ys, sortedArray :+ x)
        else
          merge(xs, ysTail, sortedArray :+ y)
    }
    if (xs.length < 2)
      xs
    else {
      val mid = xs.length / 2
      merge(mergesort(xs.slice(0, mid)), mergesort(xs.slice(mid, xs.length)), List())
    }
  }
}
