
fun main() {
  val t = readLine()!!.toInt()

  repeat(t) {
    val input = readLine()!!.split(" ").map { it.toInt() }
    val str = readLine()!!
    
    var maxAllowedOperations = input[1]

    val lowerCaseCounts = mutableMapOf<Char, Int>()
    val upperCaseCounts = mutableMapOf<Char, Int>()
    for (char in str) {
      when {
        char.isLowerCase() -> lowerCaseCounts[char] = lowerCaseCounts.getOrDefault(char, 0) + 1
        else -> upperCaseCounts[char] = upperCaseCounts.getOrDefault(char, 0) + 1
      }
    }

    var allChars = "abcdefghijklmnopqrstuvwxyz"

    var totalBerls = 0
    for (char in allChars) {
      val upperCaseChar = when {
        char.isLowerCase() -> char.toUpperCase()
        else -> char
      }
      val lowerCaseChar = upperCaseChar.toLowerCase()
      val upperCaseCharCount = upperCaseCounts.getOrDefault(upperCaseChar, 0)
      val lowerCaseCharCount = lowerCaseCounts.getOrDefault(lowerCaseChar, 0)

      if (lowerCaseCharCount == upperCaseCharCount) {
        upperCaseCounts[upperCaseChar] = 0
        lowerCaseCounts[lowerCaseChar] = 0
        totalBerls += upperCaseCharCount
      } else if (lowerCaseCharCount > upperCaseCharCount) {
        lowerCaseCounts[lowerCaseChar] = lowerCaseCharCount - upperCaseCharCount
        upperCaseCounts[upperCaseChar] = 0
        totalBerls += upperCaseCharCount
      } else {
        upperCaseCounts[upperCaseChar] = upperCaseCharCount - lowerCaseCharCount
        lowerCaseCounts[lowerCaseChar] = 0
        totalBerls += lowerCaseCharCount
      }
    }
 
    if (maxAllowedOperations > 0) {
      for (char in allChars) {
        val upperCaseChar = when {
          char.isLowerCase() -> char.toUpperCase()
          else -> char
        }
        val lowerCaseChar = upperCaseChar.toLowerCase()
        val upperCaseCharCount = upperCaseCounts.getOrDefault(upperCaseChar, 0)
        val lowerCaseCharCount = lowerCaseCounts.getOrDefault(lowerCaseChar, 0)
        
        val maxCount = maxOf(upperCaseCharCount, lowerCaseCharCount)
        if (maxCount == 0) {
          continue
        }
        val operationsToBeDone = maxCount / 2
        if (operationsToBeDone > maxAllowedOperations) {
          totalBerls += maxAllowedOperations
          maxAllowedOperations = 0
        } else {
          totalBerls += operationsToBeDone
          maxAllowedOperations -= operationsToBeDone
        }
        if (maxAllowedOperations == 0) {
          break
        }
      }
    }

    // println(lowerCaseCounts)
    // println(upperCaseCounts)

    println(totalBerls)
  }
}
