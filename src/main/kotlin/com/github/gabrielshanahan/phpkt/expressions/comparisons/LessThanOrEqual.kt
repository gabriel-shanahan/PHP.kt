package com.github.gabrielshanahan.phpkt.expressions.comparisons

import com.github.gabrielshanahan.phpkt.Expression
import com.github.gabrielshanahan.phpkt.expressions.scalars.Number
import com.github.gabrielshanahan.phpkt.expressions.scalars.String

/**
 * An less than or equal comparison in the form [lhs] <= [rhs].
 *
 * @param lhs The left hand side [Expression]
 * @param rhs The right hand side [Expression]
 */
data class LessThanOrEqual(private val lhs: Expression, private val rhs: Expression) : Expression() {
    override fun toPhpStr(): kotlin.String = lhs.toPhpStr() + " <= " + rhs.toPhpStr()
}

/**
 * Convenience method for creating less than or equal comparisons.
 *
 * @param rhs The right hand side
 */
infix fun Expression.lte(rhs: Expression) = LessThanOrEqual(this, rhs)

/**
 * Overload for a Kotlin string on the right hand side
 *
 * @param rhs The right hand side
 */
infix fun Expression.lte(rhs: kotlin.String) = LessThanOrEqual(this, String(rhs))

/**
 * Overload for a Kotlin string on the left hand side
 *
 * @param rhs The right hand side
 */
infix fun kotlin.String.lte(rhs: Expression) = LessThanOrEqual(String(this), rhs)

/**
 * Overload for a Kotlin number on the right hand side
 *
 * @param rhs The right hand side
 */
infix fun Expression.lte(rhs: kotlin.Number) = LessThanOrEqual(this, Number(rhs))

/**
 * Overload for a Kotlin number on the left hand side
 *
 * @param rhs The right hand side
 */
infix fun kotlin.Number.lte(rhs: Expression) = LessThanOrEqual(Number(this), rhs)
