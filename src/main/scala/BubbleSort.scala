/**
  * Created by Robert-PC on 8/29/2017.
  */
trait BubbleSort {
  def bubbleSortInnerLoop(xs: List[Int]): List[Int] = {
    xs match{
      case Nil        => List()
      case x::Nil     => List(x)
      case x::y::tail => List(x.min(y)) ::: bubbleSortInnerLoop(List(x.max(y)) ::: tail)
    }
  }

  def bubbleSort(xs: List[Int], index: Int): List[Int] = {
   if(index == xs.length)
     xs
   else
     bubbleSort(bubbleSortInnerLoop(xs), index + 1)
  }
}
