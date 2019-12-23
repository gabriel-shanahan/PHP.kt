package com.github.gabrielshanahan.phpkt.expressions

import com.github.gabrielshanahan.phpkt.expressions.scalars.Number
import com.github.gabrielshanahan.phpkt.expressions.scalars.String

/**
 * A PHP variable with the name [name].
 *
 * Because PHP is messed up, any byte sequence constitutes a valid PHP name using the ${} syntax. We consider this to
 * be black magic and do not support it, instead permitting only names consisting of alphanumeric characters or
 * underscores, with the additional condition that the first character cannot be a number.
 *
 * The indexed access operator is overloaded to allow working with arrays.
 *
 * When an invalid name is passed, an exception is thrown.
 *
 * @param name The name of the variable.
 */
data class Variable(private val name: kotlin.String) : Expression() {

    /**
     * Performs checks on the variable name. The first letter must be either a letter or an underscore, the rest must be
     * alphanumeric or an underscore.
     */
    init {
        if (!name.first().isLetter() && name.first() != '_') {
            throw InvalidVariableName("Variable names must start with a letter or underscore, but got $name.")
        }
        if (!name.all { it.isLetterOrDigit() || it == '_' }) {
            throw InvalidVariableName("Variable names can only contain letters, digits, or underscores, but got $name.")
        }
    }

    /**
     * Holds the indexes used when accessing this variable as an array.
     */
    private val indexes: MutableList<Expression?> = mutableListOf()

    override fun toPhpStr(): kotlin.String = "\$$name" + indexes.joinToString("") {
        "[" + (it?.toPhpStr() ?: "") + "]"
    }

    /**
     * Allows working with arrays. To render the shorthand for appending (empty brackets), pass null.
     *
     * @param expr The expression which will be rendered between the array access brackets (pass null to render nothing)
     */
    operator fun get(expr: Expression?) = apply {
        indexes.add(expr)
    }
    /**
     * Overload for Kotlin strings
     *
     * @param key The key
     */
    operator fun get(key: kotlin.String) = apply {
        indexes.add(String(key))
    }
    /**
     * Overload for Kotlin ints. Even though PHP will accept floating point accessors as valid code, the numbers are
     * truncated to their int value, so we don't allow that here.
     *
     * @param index The index
     */
    operator fun get(index: Int) = apply {
        indexes.add(Number(index))
    }

    /**
     * Thrown when an invalid variable name is passed to Variable constructor.
     *
     * @param msg The exception message.
     */
    class InvalidVariableName(msg: kotlin.String) : Throwable(msg)
}

/**
 * Helper property to convert Kotlin strings to PHP Variable objects.
 */
fun `$`(name: kotlin.String) = Variable(name)
