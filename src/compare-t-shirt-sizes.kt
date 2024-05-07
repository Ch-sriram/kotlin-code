fun compareInts(a: Int, b: Int, indicator: Char): Char {
  return when {
    a < b -> when {
      indicator == 'S' -> '>'
      else -> '<'
    }
    a > b -> when {
      indicator == 'S' -> '<'
      else -> '>'
    }
    else -> '='
  }
}

fun compareSizes(a: String, b: String): Char {
  val aSizeBase = a[a.length - 1]
  val bSizeBase = b[b.length - 1]

  return if (aSizeBase == bSizeBase) {
    compareInts(a.length, b.length, aSizeBase)
  } else {
    when {
      aSizeBase == 'S' && bSizeBase == 'M' -> '<'
      aSizeBase == 'M' && bSizeBase == 'L' -> '<'
      aSizeBase == 'S' && bSizeBase == 'L' -> '<'
      else -> '>'
    }
  }
}

fun main() {
  val t = readLine()!!.toInt()

  repeat(t) {
    val inputs = readLine()!!.split(" ")
    val (a, b) = inputs
    println(compareSizes(a, b))
  }
}
