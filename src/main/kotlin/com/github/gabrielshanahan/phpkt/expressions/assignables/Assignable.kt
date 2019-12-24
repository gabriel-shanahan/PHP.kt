package com.github.gabrielshanahan.phpkt.expressions.assignables

import com.github.gabrielshanahan.phpkt.Expression

/**
 * The base class for PHP assignables with the name [name].
 *
 * There are basically two types of assignables - [simple variables][SimpleVariable] (e.g. $a) or
 * [variables which are indexed as an array][IndexedVariable] (e.g. `$a["b"][]`). It would be natural to model the
 * indexed version as deriving from the simple version, however we run into problems when defining
 * [com.github.gabrielshanahan.phpkt.statements.constructs.looping.ForEach], where it is required that the $key and
 * $value are only simple variables. For this reason, we have to model the situation with two classes that inherit from
 * a common superclass - [Assignable].
 *
 * Because PHP is messed up, any byte sequence constitutes a valid PHP name using the ${} syntax. We consider this to
 * be black magic and do not support it, instead permitting only names consisting of alphanumeric characters or
 * underscores, with the additional condition that the first character cannot be a number.
 *
 * When an invalid name is passed, an exception is thrown.
 *
 * @param name The name of the variable.
 */
abstract class Assignable(private val name: String) : Expression() {

    /**
     * Performs checks on the variable name. The first letter must be either a letter or an underscore, the rest must be
     * alphanumeric or an underscore.
     *
     * TODO: Refactor into "name" component that would be used by function as well
     */
    init {
        if (!name.first().isLetter() && name.first() != '_') {
            throw InvalidVariableName("Variable names must start with a letter or underscore, but got $name.")
        }
        if (!name.all { it.isLetterOrDigit() || it == '_' }) {
            throw InvalidVariableName("Variable names can only contain letters, digits, or underscores, but got $name.")
        }
    }

    override fun toPhpStr(): String = "\$$name"

    /**
     * Thrown when an invalid variable name is passed to Variable constructor.
     *
     * @param msg The exception message.
     */
    class InvalidVariableName(msg: String) : Throwable(msg)
}
