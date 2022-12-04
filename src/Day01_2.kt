package day01p2
import root.readText

private object Regex {
    val Newline = "(\r|\n|\r\n)".toRegex()
    val EmptyLine = "(\r|\n|\r\n){2}".toRegex()
}

fun main() {
    readText("day1")
        .split(Regex.EmptyLine)
        .map { block -> block.split(Regex.Newline).sumOf { line -> line.toInt() } }
        .sortedDescending()
        .take(3)
        .sum()
        .let { println("day1p2: $it") }
}
