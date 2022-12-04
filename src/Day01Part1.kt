package day01part1

import root.readText

private object Regex {
    val Newline = "(\r|\n|\r\n)".toRegex()
    val EmptyLine = "(\r|\n|\r\n){2}".toRegex()
}

fun main() {
    readText("day1")
        .split(Regex.EmptyLine)
        .maxOf { block -> block.split(Regex.Newline).sumOf { line -> line.toInt() } }
        .let { println("day01p1: $it") }
}
