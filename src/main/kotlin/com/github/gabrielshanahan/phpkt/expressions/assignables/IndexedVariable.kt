package com.github.gabrielshanahan.phpkt.expressions.assignables

import com.github.gabrielshanahan.phpkt.expressions.Expression
import com.github.gabrielshanahan.phpkt.expressions.scalars.Number
import com.github.gabrielshanahan.phpkt.expressions.scalars.String

/**
 * An indexed variable with name [name], such as `$a["b"][]`.
 *
 * @param name The name of the variable.
 * @param indices Holds the indices used when accessing this variable as an array (or null when [] should be rendered).
 */
data class IndexedVariable(
    private val name: kotlin.String,
    val indices: MutableList<Expression?>
) : Assignable(name) {

    override fun toPhpStr(): kotlin.String = super.toPhpStr() + indices.joinToString("") {
        "[" + (it?.toPhpStr() ?: "") + "]"
    }
}

/**
 * DSL method to work with array access. To render the shorthand for appending (empty brackets), pass null.
 * Returns self for chaining.
 *
 * @param expr The expression which will be rendered between the array access brackets (pass null to render nothing)
 */
operator fun IndexedVariable.get(expr: Expression?) = apply {
    indices.add(expr)
}

/**
 * DSL method to work with array access. Allows convenient creation of an [IndexedVariable] from a [SimpleVariable]
 *
 * @param expr The expression which will be rendered between the array access brackets (pass null to render nothing)
 * @see IndexedVariable.get
 */
operator fun SimpleVariable.get(expr: Expression?) = IndexedVariable(name, mutableListOf(expr))

/**
 * Overload for Kotlin strings
 *
 * @param key The key
 */
operator fun IndexedVariable.get(key: kotlin.String) = get(String(key))

/**
 * Overload for Kotlin strings
 *
 * @param key The key
 * @see IndexedVariable.get
 */
operator fun SimpleVariable.get(key: kotlin.String) = IndexedVariable(name, mutableListOf(String(key)))

/**
 * Overload for Kotlin ints. Even though PHP will accept floating point accessors as valid code, the numbers are
 * truncated to their int value, so we don't allow that here.
 *
 * @param index The index
 */
operator fun IndexedVariable.get(index: Int) = get(Number(index))

/**
 * Overload for Kotlin ints.
 *
 * @param index The index
 * @see IndexedVariable.get
 */
operator fun SimpleVariable.get(index: Int) = IndexedVariable(name, mutableListOf(Number(index)))
