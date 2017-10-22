import NtimesN.InsertSort

import scala.util.Random

/**
  * Created by Robert-PC on 8/30/2017.
  */


/* If someone wants to check that indeed the lists are sorted, you can print time -> it returns the result from the function */
object Main extends App {
  def time[R](block: => R, sortingMethod: String): R = {
    val t0 = System.currentTimeMillis()
    val result = block // call-by-name
    val t1 = System.currentTimeMillis()
    println(s"Elapsed time on $sortingMethod: " + (t1 - t0) + "ms")
    result
  }

  // bubblesort actually cracks on a list of 10000 elements -> used one with 2k elements, 5 times lesser
  // => solved with tailrec, now goes up to ~6k elements on my laptop with jvm memory allocation 128min-1024max.
  //time(bubbleSort((1 to 1000).toList.map(_ => Random.nextInt().abs), 0), "Bubblesort")
  //Thread.sleep(2000)

  //time(mergeSort((1 to 10000).toList.map(_ => Random.nextInt().abs)), "Mergesort")
  //Thread.sleep(2000)

  //time(quickSort((1 to 10000).toList.map(_ => Random.nextInt().abs)), "Quicksort")
  //Thread.sleep(2000)

  //countsort doesn't work on very large numbers
  //time(countSort((1 to 10000).toList.map(_ => Random.nextInt() % 100000 + 10000.abs)), "Countsort")
  //Thread.sleep(2000)

  //time(combSort((1 to 10000).toList.map(_ => Random.nextInt().abs)), "Combsort")
  //Thread.sleep(2000)\

  time(InsertSort.insertSort((1 to 1000).toList.map(_ => Random.nextInt().abs), 0), "InsertSort")
  //println(insertSort(List(5,4,3,2,1), 0))
  Thread.sleep(2000)
}
