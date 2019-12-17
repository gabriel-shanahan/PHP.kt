package cz.php.kt.expressions.assignments

import cz.php.kt.expressions.Expression
import cz.php.kt.expressions.Variable

/**
 * Represents an assignment in the form [lhs] = [rhs].
 *
 * @param lhs The left hand side [Variable]
 * @param rhs The right hand side [Expression]
 */
data class Assignment(private val lhs: Variable, private val rhs: Expression) : Expression() {
    override fun asPhp(): String = lhs.asPhp() + " = " + rhs.asPhp()
}

/**
 * Helper function to allow concise creation of assignments.
 *
 * @param rhs The right hand side [Expression]
 */
infix fun Variable.`=`(rhs: Expression) = Assignment(this, rhs)
