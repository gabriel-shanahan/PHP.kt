package com.github.gabrielshanahan.phpkt.expressions.functions

import com.github.gabrielshanahan.phpkt.Node
import com.github.gabrielshanahan.phpkt.expressions.Expression
import com.github.gabrielshanahan.phpkt.expressions.scalars.Number
import com.github.gabrielshanahan.phpkt.expressions.scalars.String

/**
 * A function call in the form of [name] ([arguments]).
 *
 * @param name The function to be called.
 * @param arguments A list of arguments.
 */
data class FunctionCall(val name: kotlin.String, val arguments: List<Expression>) : Expression() {
    override fun toPhpStr(): kotlin.String =
        name + arguments.joinToString(prefix = "(", transform = Node::toPhpStr, postfix = ")")
}

/**
 * Convenience method for iteratively building up a function call from a function name and a "list" of arguments.
 * Inspired by the [Haskell $ operator, which signifies function application](https://wiki.haskell.org/$)
 */
infix fun kotlin.String.`$`(argument: Expression) = FunctionCall(this, listOf(argument))

/**
 * Convenience method for iteratively building up a function call from a function name and a "list" of arguments.
 */
infix fun FunctionCall.`,`(argument: Expression) = FunctionCall(name, arguments + argument)

/**
 * Overload for Kotlin strings.
 */
infix fun FunctionCall.`,`(argument: kotlin.String) = FunctionCall(name, arguments + String(argument))

/**
 * Overload for Kotlin numbers.
 */
infix fun FunctionCall.`,`(argument: kotlin.Number) = FunctionCall(name, arguments + Number(argument))
