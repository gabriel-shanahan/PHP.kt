package com.github.gabrielshanahan.phpkt.expressions.assignments

import com.github.gabrielshanahan.phpkt.Expression
import com.github.gabrielshanahan.phpkt.expressions.assignables.Assignable
import com.github.gabrielshanahan.phpkt.expressions.assignables.SimpleVariable
import com.github.gabrielshanahan.phpkt.expressions.scalars.Number
import com.github.gabrielshanahan.phpkt.expressions.scalars.String
import java.util.*

/**
 * An assignment in the form [lhs] = [rhs]. Since this is an Expression, there is no semicolon at the end (to permit
 * things like $a = $b = 1).
 *
 * @param lhs The left hand side [SimpleVariable]
 * @param rhs The right hand side [Expression]
 */
data class Assignment(private val lhs: SimpleVariable, private val rhs: Expression) : Expression() {
    override fun toPhpStr(): kotlin.String = lhs.toPhpStr() + " = " + rhs.toPhpStr()

    override fun equals(other: Any?): Boolean = other is Assignment && other.lhs == lhs && other.rhs == rhs

    override fun hashCode(): Int = Objects.hash(lhs, rhs)
}

    /**
     * Convenience method for creating Assignments outside of
     * [CompoundStatements][com.github.gabrielshanahan.phpkt.statements.CompoundStatement].
     *
     * @param rhs The right hand side
     */
    infix fun SimpleVariable.`=`(rhs: Expression) = Assignment(this, rhs)

    /**
     * Overload for Kotlin strings.
     *
     * @param rhs The right hand side
     */
    infix fun SimpleVariable.`=`(rhs: kotlin.String) = Assignment(this, String(rhs))

    /**
     * Overload for Kotlin numbers.
     *
     * @param rhs The right hand side
     */
    infix fun SimpleVariable.`=`(rhs: kotlin.Number) = Assignment(this, Number(rhs))
