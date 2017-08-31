package NplusR

/**
  * Created by Robert-PC on 8/29/2017.
  */
trait CountSort {
  def countsort(input: List[Int]): List[Int] = {
    def key(current: Int, min: Int) = {
      current - min
    }
    val countingArray = new Array[Int](input.length)
    val sortedArray = new Array[Int](input.length)
    val min = input.min
    input.foreach{el => countingArray(key(el, min)) += 1;}

    countingArray.foreach{
      el =>
        if (key(el, min) > 0)
          countingArray(key(el, min)) += countingArray(key(el, min) - 1)
    }

    input.foreach{
      el =>
        println(el)
        val currentIndex = countingArray(key(el, min))
        countingArray(key(el, min)) -=  1
        sortedArray(currentIndex) = el
    }

    sortedArray.toList
  }

}
