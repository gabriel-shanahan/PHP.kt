package com.github.gabrielshanahan.phpkt.expressions.comparisons

import com.github.gabrielshanahan.phpkt.expressions.Expression
import com.github.gabrielshanahan.phpkt.expressions.scalars.Number
import com.github.gabrielshanahan.phpkt.expressions.scalars.String

/**
 * An not equals comparison in the form [lhs] != [rhs].
 *
 * @param lhs The left hand side [Expression]
 * @param rhs The right hand side [Expression]
 */
data class NotEqual(private val lhs: Expression, private val rhs: Expression) : Expression() {
    override fun toPhpStr(): kotlin.String = lhs.toPhpStr() + " != " + rhs.toPhpStr()
}

/**
 * Convenience method for creating not equals comparisons.
 *
 * @param rhs The right hand side
 */
infix fun Expression.`!=`(rhs: Expression) = NotEqual(this, rhs)

/**
 * Overload for a Kotlin string on the right hand side
 *
 * @param rhs The right hand side
 */
infix fun Expression.`!=`(rhs: kotlin.String) = NotEqual(this, String(rhs))

/**
 * Overload for a Kotlin string on the left hand side
 *
 * @param rhs The right hand side
 */
infix fun kotlin.String.`!=`(rhs: Expression) = NotEqual(String(this), rhs)

/**
 * Overload for a Kotlin number on the right hand side
 *
 * @param rhs The right hand side
 */
infix fun Expression.`!=`(rhs: kotlin.Number) = NotEqual(this, Number(rhs))

/**
 * Overload for a Kotlin number on the left hand side
 *
 * @param rhs The right hand side
 */
infix fun kotlin.Number.`!=`(rhs: Expression) = NotEqual(Number(this), rhs)
