/**
  * Created by Robert-PC on 8/29/2017.
  */
trait QuickSort {
  def quicksort(list: List[Int]): List[Int] = {
    list match {
      case Nil     => Nil
      case a::Nil  => List(a)
      case a::tail => quicksort(tail.filter(x => x <= a)) ::: List(a) ::: quicksort(tail.filter(x => x > a))
    }
  }
}
