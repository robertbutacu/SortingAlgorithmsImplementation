package NLogN

/**
  * Created by Robert-PC on 8/29/2017.
  */
trait MergeSort {


  def mergesort(xs: List[Int]): List[Int] = {
    def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
      case (xs, Nil)          => xs
      case (Nil, ys)          => ys
      case (x :: xs, y :: ys) =>
        if (x < y)
          x :: merge(xs, ys)
        else
          y :: merge(xs, ys)
    }
    if (xs.length < 2)
      xs
    else {
      val mid = xs.length / 2
      merge(mergesort(xs.slice(0, mid)), mergesort(xs.slice(mid, xs.length)))
    }
  }


}
