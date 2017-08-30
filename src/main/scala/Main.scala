import NLogN.NLogN
import NplusR.NplusR
import NtimesN.NtimesN

import scala.util.Random

/**
  * Created by Robert-PC on 8/30/2017.
  */


/* If someone wants to check that indeed the lists are sorted, you can print time -> it returns the result from the function */
object Main extends App
  with NLogN
  with NtimesN
  with NplusR {
  def time[R](block: => R, sortingMethod: String): R = {
    val t0 = System.currentTimeMillis()
    val result = block // call-by-name
    val t1 = System.currentTimeMillis()
    println(s"Elapsed time on $sortingMethod: " + (t1 - t0) + "ms")
    result
  }

  // bubblesort actually cracks on a list of 10000 elements -> used one with 2k elements, 5 times lesser
  time(bubbleSort((1 to 2000).toList.map(_ => Random.nextInt().abs), 0), "Bubblesort")
  Thread.sleep(2000)

  time(mergesort((1 to 10000).toList.map(_ => Random.nextInt().abs)), "Mergesort")
  Thread.sleep(2000)

  time(quicksort((1 to 1000000).toList.map(_ => Random.nextInt().abs)), "Quicksort")
  Thread.sleep(2000)
}
