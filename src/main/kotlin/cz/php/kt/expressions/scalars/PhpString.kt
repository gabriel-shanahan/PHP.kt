package cz.php.kt.expressions.scalars

import cz.php.kt.Node

/**
 * Represents a _double quoted_ string in PHP. Be aware that this means that things such as escape sequences, dollar
 * signs etc. will be evaluated when run as PHP code.
 *
 * @param str The string value.
 */
class PhpString(private val str: String) : Node() {
    override fun asPhp(): String = "\"$str\""
}

/**
 * Helper function to convert kotlin strings to PHP string objects.
 */
fun String.asPhpObj(): PhpString = PhpString(this)
