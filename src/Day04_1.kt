package day04p1;

import root.readLines

fun main() {
    readLines("day4")
        .map { pair ->
            pair.split(",")
                .map { range ->
                    range.split("-")
                        .map(String::toInt)
                        .let { (start, end) -> start..end }
                }.let { (first, second) -> first to second }
        }
        .count { (first, second) -> (first - second).isEmpty() || (second - first).isEmpty() }
        .let { println("day04p1: $it") }
}

