package ch02

enum class Color(
    val r: Int, val g: Int, val b: Int
) {
    RED(255, 0, 0),
    BLACK(0, 0, 0),
    WHITE(255, 255, 255),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
}

fun main() {
    println(Color.BLUE.rgb())
    println(Color.BLUE.r)
    println(Color.BLUE.g)
    println(Color.BLUE.b)
}