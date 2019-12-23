package com.github.gabrielshanahan.phpkt.expressions.comparisons

import com.github.gabrielshanahan.phpkt.expressions.Expression
import com.github.gabrielshanahan.phpkt.expressions.scalars.Number
import com.github.gabrielshanahan.phpkt.expressions.scalars.String

/**
 * An less than comparison in the form [lhs] < [rhs].
 *
 * @param lhs The left hand side [Expression]
 * @param rhs The right hand side [Expression]
 */
data class LessThan(private val lhs: Expression, private val rhs: Expression) : Expression() {
    override fun toPhpStr(): kotlin.String = lhs.toPhpStr() + " < " + rhs.toPhpStr()
}

/**
 * Convenience method for creating less than comparisons.
 *
 * @param rhs The right hand side
 */
infix fun Expression.lt(rhs: Expression) = LessThan(this, rhs)

/**
 * Overload for a Kotlin string on the right hand side
 *
 * @param rhs The right hand side
 */
infix fun Expression.lt(rhs: kotlin.String) = LessThan(this, String(rhs))

/**
 * Overload for a Kotlin string on the left hand side
 *
 * @param rhs The right hand side
 */
infix fun kotlin.String.lt(rhs: Expression) = LessThan(String(this), rhs)

/**
 * Overload for a Kotlin number on the right hand side
 *
 * @param rhs The right hand side
 */
infix fun Expression.lt(rhs: kotlin.Number) = LessThan(this, Number(rhs))

/**
 * Overload for a Kotlin number on the left hand side
 *
 * @param rhs The right hand side
 */
infix fun kotlin.Number.lt(rhs: Expression) = LessThan(Number(this), rhs)
