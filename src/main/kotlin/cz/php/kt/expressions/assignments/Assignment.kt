package cz.php.kt.expressions.assignments

import cz.php.kt.expressions.Expression
import cz.php.kt.expressions.Variable

/**
 * An assignment in the form [lhs] = [rhs]. Since this is an Expression, there is no semicolon at the end (to permit
 * things like $a = $b = 1)
 *
 * @param lhs The left hand side [Variable]
 * @param rhs The right hand side [Expression]
 */
data class Assignment(private val lhs: Variable, private val rhs: Expression) : Expression() {
    override fun toPhpStr(): String = lhs.toPhpStr() + " = " + rhs.toPhpStr()
}

/**
 * A convenience method for creating Assignments.
 *
 * @param rhs The right hand side [Expression]
 */
infix fun Variable.`=`(rhs: Expression) = Assignment(this, rhs)
