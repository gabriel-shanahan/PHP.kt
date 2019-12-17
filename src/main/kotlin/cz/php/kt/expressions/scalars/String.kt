package cz.php.kt.expressions.scalars

import cz.php.kt.expressions.Expression

/**
 * Represents a _double quoted_ string in PHP. Be aware that this means that things such as escape sequences, dollar
 * signs etc. will be evaluated when run as PHP code.
 *
 * @param str The string value.
 */
data class String(private val str: kotlin.String) : Expression() {
    override fun toPhpStr(): kotlin.String = "\"$str\""
}

/**
 * Helper property to convert Kotlin strings to PHP String objects.
 */
val kotlin.String.phpObj get() = String(this)
