package NLogN

/**
  * Created by Robert-PC on 8/29/2017.
  */
trait MergeSort {


  def mergesort(xs: List[Int]): List[Int] = {
    def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
      case (_, Nil)          => xs
      case (Nil, _)          => ys
      case (x :: xsTail, y :: ysTail) =>
        if (x < y)
          x :: merge(xsTail, ys)
        else
          y :: merge(xs, ysTail)
    }
    if (xs.length < 2)
      xs
    else {
      val mid = xs.length / 2
      merge(mergesort(xs.slice(0, mid)), mergesort(xs.slice(mid, xs.length)))
    }
  }


}
