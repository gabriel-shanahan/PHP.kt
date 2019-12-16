package cz.php.kt.expressions.scalars

import cz.php.kt.Node
import kotlin.String

/**
 * Represents a number.
 *
 * @param value The value
 */
data class Number(private val value: kotlin.Number) : Node() {
    override fun asPhp(): String = value.toString()
}

/**
 * Helper function to convert Kotlin numbers to PHP Number objects.
 */
fun kotlin.Number.asPhpObj() = Number(this)
