package day02part1

import root.readLines

private enum class Sign(val points: Int) {
    Rock(1),
    Paper(2),
    Scissors(3);

    fun play(other: Sign) = if (this == other) {
        Result.Draw
    } else if (this == Rock) {
        if (other == Scissors) Result.Win else Result.Loss
    } else if (this == Paper) {
        if (other == Rock) Result.Win else Result.Loss
    } else {
        if (other == Paper) Result.Win else Result.Loss
    }
}

private enum class Result(val points: Int) {
    Win(6),
    Draw(3),
    Loss(0)
}

private object SignLookup {
    private val signs = mapOf(
        "A" to Sign.Rock,
        "X" to Sign.Rock,
        "B" to Sign.Paper,
        "Y" to Sign.Paper,
        "C" to Sign.Scissors,
        "Z" to Sign.Scissors
    )

    fun lookup(name: String) = signs[name]!!
}

fun main() {
    readLines("day2").sumOf {
        it.split(" ").map { s -> SignLookup.lookup(s) }.let { (opp, you) ->
            you.points + you.play(opp).points
        }
    }.let { println("day02p1: $it") }
}

