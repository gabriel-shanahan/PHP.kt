package cz.php.kt.expressions

import cz.php.kt.Node

/**
 * Represents a Node that _evaluates to a specific value in PHP_. An Expression does not have any children, i.e. it is
 * not a block. This does not mean it cannot have attributes - a function call is an expression, for example.
 *
 * When attempting to access children, an exception is thrown.
 */
abstract class Expression : Node() {
    final override val children
        get() = throw InvalidOperationException("Accessing children on an expression makes no sense.")

    /**
     * Thrown when children are accessed on an expression.
     *
     * @param msg The exception message.
     */
    class InvalidOperationException(msg: String) : Throwable(msg)
}
