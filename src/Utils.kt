package root

import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readLines(name: String) = File("src/files", "$name.txt")
    .readLines()

fun readText(name: String) = File("src/files", "$name.txt")
    .readText().trim()

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')


/**
 * Compare two Strings and find characters that are contained in both (duplicates)
 */
infix fun String.intersect(other: String): Set<Char> {
    return this.toCharArray() intersect other.asIterable().toSet()
}
