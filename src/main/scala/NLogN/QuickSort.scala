package NLogN

/**
  * Created by Robert-PC on 8/29/2017.
  */

/**
  *   The beauty of PF is shown in the Quicksort algorithm.
  *   Instead of memorising anything about the "wall", etc about quicksort, this is how quicksort works:
  *     1. pick a pivot
  *     2. create a list containing a recursive call to quicksort(elements smaller than pivot),
  *       concatenated with current element, with quicksort(elements bigger than pivot).
  *   That's it : 4 lines, compared to around 20 of imperative programming.
  *
  *   Slightly complicated video about this: https://www.youtube.com/watch?v=aQiWF4E8flQ    .
  */
trait QuickSort {
  def quickSort(list: List[Int]): List[Int] = {
    list match {
      case Nil     => Nil
      case a::Nil  => List(a)
      case a::tail => quickSort(tail.filter(x => x <= a)) ::: List(a) ::: quickSort(tail.filter(x => x > a))
    }
  }
}
