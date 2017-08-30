import scala.util.Random

/**
  * Created by Robert-PC on 8/30/2017.
  */
object Main extends App with QuickSort with BubbleSort{
  def time[R](block: => R, sortingMethod: String): R = {
    val t0 = System.currentTimeMillis()
    val result = block    // call-by-name
    val t1 = System.currentTimeMillis()
    println(s"Elapsed time on $sortingMethod: " + (t1 - t0) + "ms")
    result
  }

  //println(time (quicksort((1 to 10000).toList.map(_ => Random.nextInt().abs)), "Quicksort"))
  println(bubbleSort(List(5,4,3,3,2,1), 0))
}
