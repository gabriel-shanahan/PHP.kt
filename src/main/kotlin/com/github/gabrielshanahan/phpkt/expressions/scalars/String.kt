package com.github.gabrielshanahan.phpkt.expressions.scalars

import com.github.gabrielshanahan.phpkt.Expression

/**
 * A _double quoted_ string in PHP. Be aware that this means that things such as escape sequences, dollar
 * signs etc. will be evaluated when run as PHP code.
 *
 * @param str The string value.
 */
data class String(private val str: kotlin.String) : Expression() {
    override fun toPhpStr(): kotlin.String = "\"$str\""
}

/**
 * A convenience property that returns Kotlin strings as PHP Strings.
 */
val kotlin.String.phpObj get() = String(this)
