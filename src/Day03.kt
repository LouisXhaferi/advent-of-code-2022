package day03p1;

import root.intersect
import root.readLines

fun main() = readLines("day3")
    .map(::compartmentalize)
    .flatMap { (left, right) -> left intersect right }
    .map(::prioritizeItem)
    .sum()
    .let { println("day03p1: $it") }

private fun compartmentalize(rucksack: String) =
    (rucksack.length / 2).let { mid -> rucksack.substring(0 until mid) to rucksack.substring(mid) }

private fun prioritizeItem(item: Char) = when (item) {
    in 'a'..'z' -> item - 'a' + 1
    in 'A'..'Z' -> (item - 'A') + 27
    else -> throw IllegalArgumentException("invalid input")
}
