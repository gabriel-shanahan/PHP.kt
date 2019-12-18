package cz.php.kt.expressions.scalars

import cz.php.kt.expressions.Expression
import kotlin.String

/**
 * A number.
 *
 * @param value The value
 */
data class Number(private val value: kotlin.Number) : Expression() {
    override fun toPhpStr(): String = value.toString()
}

/**
 * A convenience property that returns Kotlin numbers as PHP Numbers.
 */
val kotlin.Number.phpObj get() = Number(this)
