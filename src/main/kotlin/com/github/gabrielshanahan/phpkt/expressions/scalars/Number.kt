package com.github.gabrielshanahan.phpkt.expressions.scalars

import com.github.gabrielshanahan.phpkt.expressions.Expression
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
