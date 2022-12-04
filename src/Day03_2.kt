package day03p2;

import root.readLines

fun main() = readLines("day3")
    .chunked(3)
    .map { (first, second, third) -> (first.toSet() intersect second.toSet() intersect third.toSet()).first() }
    .map(::prioritizeItem)
    .sum()
    .let { println("day03p2: $it") }

private fun prioritizeItem(item: Char) = when (item) {
    in 'a'..'z' -> item - 'a' + 1
    in 'A'..'Z' -> (item - 'A') + 27
    else -> throw IllegalArgumentException("invalid input")
}
