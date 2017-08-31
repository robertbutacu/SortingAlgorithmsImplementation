package NplusR

/**
  * Created by Robert-PC on 8/29/2017.
  */
trait CountSort {
  def countsort(input: List[Int]): List[Int] = {
    def key(current: Int, min: Int): Int = {
      current - min
    }
    val countingArray = new Array[Int](input.length)
    val sortedArray = new Array[Int](input.length)
    val min = input.min

    input.foreach{el => countingArray(key(el, min)) += 1}

    for(i <- 1 to (input.max - min))
      countingArray(i) += countingArray(i - 1)

    input.foreach{
      el =>
        val currentIndex = countingArray(key(el, min))
        countingArray(key(el, min)) -=  1
        sortedArray(currentIndex - 1) = el
    }

    sortedArray.toList
  }
}
