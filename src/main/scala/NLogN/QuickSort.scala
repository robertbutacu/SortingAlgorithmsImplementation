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
object QuickSort {
  def quickSort(input: List[Int]): List[Int] = {
    input match {
      case Nil     => Nil
      case x::Nil  => List(x)
      case x::tail => quickSort(tail.filter(el => el <= x)) ::: List(x) ::: quickSort(tail.filter(el => el > x))
    }
  }
}
