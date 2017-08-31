package NplusR

/**
  * Created by Robert-PC on 8/29/2017.
  */
/**
  *   Countsort is extremely effective and easy to understand.
  *   !Careful! It doesn't work on very large numbers because of JVM heap( an array can only be so large).
  *
  *   With that being said, the working mechanism is the following:
  *     1. count the number of appearances of every number and memorise it in an array =>
  *         it requires an array of input.max - input.min elements, since it is unknown what numbers there are =>
  *           in the future, when you see "looking up the index in the countArray", it is meant looking up by
  *             number you're looking for - input.min.
  *     2. starting from the index 0, start adding the number of appearances up until the current index
  *         to the current index' count.
  *           Example: BEFORE 0 1 0 2 0 0 5
  *                    AFTER  0 1 1 3 3 3 8
  *     3. for each element for the input, the sorted array can be obtained by looking up in the countArray the index of what
  *         index it will occupy and then decrementing the count from the array.
  *
  *   Explanatory video: https://www.youtube.com/watch?v=7zuGmKfUt7s   .
  */
trait CountSort {
  def countsort(input: List[Int]): List[Int] = {
    def key(current: Int, min: Int): Int = {
      current - min
    }

    val countingArray = new Array[Int](input.max - input.min + 1)
    val sortedArray = new Array[Int](input.length)
    val min = input.min

    input.foreach { el => countingArray(key(el, min)) += 1 }

    for (i <- 1 to (input.max - min))
      countingArray(i) += countingArray(i - 1)

    input.foreach {
      el =>
        val currentIndex = countingArray(key(el, min))
        countingArray(key(el, min)) -= 1
        sortedArray(currentIndex - 1) = el
    }

    sortedArray.toList
  }
}
