package day02part2

import root.readLines

enum class Sign(val points: Int) {
    Rock(1),
    Paper(2),
    Scissors(3);
}

enum class Result(val points: Int) {
    Win(6),
    Draw(3),
    Loss(0)
}

object Games {
    private val losesToMap = mapOf(
        Sign.Rock to Sign.Paper,
        Sign.Paper to Sign.Scissors,
        Sign.Scissors to Sign.Rock
    )

    private val winsAgainstMap = mapOf(
        Sign.Rock to Sign.Scissors,
        Sign.Paper to Sign.Rock,
        Sign.Scissors to Sign.Paper
    )

    fun expectedSign(opponent: Sign, comeout: Result) = when (comeout) {
        Result.Draw -> opponent
        Result.Win -> losesToMap[opponent]!!
        Result.Loss -> winsAgainstMap[opponent]!!
    }
}

fun main() {
    val signLookup = mapOf(
        "A" to Sign.Rock,
        "B" to Sign.Paper,
        "C" to Sign.Scissors
    )

    val resultLookup = mapOf(
        "X" to Result.Loss,
        "Y" to Result.Draw,
        "Z" to Result.Win
    )

    // TODO chunk lines and do concurrently?
    val score = readLines("day2")
        .sumOf {
            it.split(" ")
                .let {
                    val opponent = signLookup[it[0]]!!
                    val outcome = resultLookup[it[1]]!!

                    outcome.points + Games.expectedSign(opponent, outcome).points
                }
        }

    println("day02p2: $score")
}
