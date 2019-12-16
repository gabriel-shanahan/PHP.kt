package cz.php.kt.expressions

import cz.php.kt.Node

/**
 * Represents a PHP variable with the name [name].
 *
 * Because PHP is messed-up, any byte sequence constitutes a valid PHP name using the ${} syntax. We consider this to be
 * borderline offensive black magic and do not support it, instead permitting only names consisting of alphanumeric
 * characters or underscores, with the additional condition that the first character cannot be a number.
 */
class Variable(private val name: String) : Node() {

    init {
        if (!name.first().isLetter() && name.first() != '_') {
            throw InvalidVariableName("Variable names must start with a letter or underscore, but got $name.")
        }
        if (!name.all { it.isLetterOrDigit() || it == '_' }) {
            throw InvalidVariableName("Variable names can only contain letters, digits, or underscores, but got $name.")
        }
    }

    override fun asPhp(): String = "\$$name"

    class InvalidVariableName(msg: String) : Throwable(msg)
}
