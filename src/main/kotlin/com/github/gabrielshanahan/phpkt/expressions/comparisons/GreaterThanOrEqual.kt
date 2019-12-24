package com.github.gabrielshanahan.phpkt.expressions.comparisons

import com.github.gabrielshanahan.phpkt.Expression
import com.github.gabrielshanahan.phpkt.expressions.scalars.Number
import com.github.gabrielshanahan.phpkt.expressions.scalars.String

/**
 * An greather than or equal comparison in the form [lhs] >= [rhs].
 *
 * @param lhs The left hand side [Expression]
 * @param rhs The right hand side [Expression]
 */
data class GreaterThanOrEqual(private val lhs: Expression, private val rhs: Expression) : Expression() {
    override fun toPhpStr(): kotlin.String = lhs.toPhpStr() + " >= " + rhs.toPhpStr()
}

/**
 * Convenience method for creating greather than or equal comparisons.
 *
 * @param rhs The right hand side
 */
infix fun Expression.gte(rhs: Expression) = GreaterThanOrEqual(this, rhs)

/**
 * Overload for a Kotlin string on the right hand side
 *
 * @param rhs The right hand side
 */
infix fun Expression.gte(rhs: kotlin.String) = GreaterThanOrEqual(this, String(rhs))

/**
 * Overload for a Kotlin string on the left hand side
 *
 * @param rhs The right hand side
 */
infix fun kotlin.String.gte(rhs: Expression) = GreaterThanOrEqual(String(this), rhs)

/**
 * Overload for a Kotlin number on the right hand side
 *
 * @param rhs The right hand side
 */
infix fun Expression.gte(rhs: kotlin.Number) = GreaterThanOrEqual(this, Number(rhs))

/**
 * Overload for a Kotlin number on the left hand side
 *
 * @param rhs The right hand side
 */
infix fun kotlin.Number.gte(rhs: Expression) = GreaterThanOrEqual(Number(this), rhs)
