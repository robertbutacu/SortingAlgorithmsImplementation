package NplusR

/**
  * Created by Robert-PC on 8/29/2017.
  */
trait CountSort {
  def countsort(input: List[Int]): List[Int] = {
    val countingArray = (input.min to input.max).toArray
    val sortedArray = new Array[Int](input.length)

    input.foreach{el => countingArray(el-1) += 1}

    countingArray.foreach{
      el =>
        if (el > 0)
          countingArray(el) += countingArray(el - 1)
    }

    input.foreach{
      el =>
        val currentIndex = countingArray(el)
        countingArray(el) -=  1
        sortedArray(currentIndex) = el
    }

    sortedArray.toList
  }

}
