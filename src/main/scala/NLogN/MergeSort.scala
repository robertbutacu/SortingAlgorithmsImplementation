package NLogN

/**
  * Created by Robert-PC on 8/29/2017.
  */
trait MergeSort {
  def merge(xs: List[Int], ys: List[Int]): List[Int] = {
    if (xs.isEmpty)
      ys
    if (ys.isEmpty)
      xs
    if(xs.head > ys.head)
      ys.head :: merge(xs, ys.tail)
    else
      xs.head :: merge(xs.tail, ys)
  }

  def mergesort(xs: List[Int]): List[Int] = {
    if (xs.length < 2)
      xs
    else {
      val mid = xs.length / 2
      merge(mergesort(xs.slice(0, mid)), mergesort(xs.slice(mid + 1, xs.length)))
    }
  }


}
