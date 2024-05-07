fun main() {
  val t = readLine()!!.toInt()

  repeat(t) {
    val n = readLine()!!.toInt()
    val inputs = readLine()!!.split(" ").map { it.toInt() }

    val inputCounts = mutableMapOf<Int, Pair<Int, Int>>()
    for (i in inputs.indices) {
      val input = inputs[i]
      val countAndIndex: Pair<Int, Int> = inputCounts.getOrDefault(input, Pair(0, i))
      val count = countAndIndex.first
      val index = countAndIndex.second
      inputCounts[input] = Pair(count + 1, index)
    }

    for (countAndIndex in inputCounts.values) {
      if (countAndIndex.first == 1) {
        println(countAndIndex.second + 1)
        break
      }
    }
  }
}
