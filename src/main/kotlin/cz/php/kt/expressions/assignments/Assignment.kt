package cz.php.kt.expressions.assignments

import cz.php.kt.expressions.Expression
import cz.php.kt.expressions.Variable
import cz.php.kt.expressions.scalars.Number
import cz.php.kt.expressions.scalars.String

/**
 * An assignment in the form [lhs] = [rhs]. Since this is an Expression, there is no semicolon at the end (to permit
 * things like $a = $b = 1)
 *
 * @param lhs The left hand side [Variable]
 * @param rhs The right hand side [Expression]
 */
data class Assignment(private val lhs: Variable, private val rhs: Expression) : Expression() {

    override fun toPhpStr(): kotlin.String = lhs.toPhpStr() + " = " + rhs.toPhpStr()
}

/**
 * A convenience method for creating Assignments.
 *
 * @param rhs The right hand side
 */
infix fun Variable.`=`(rhs: Expression) = Assignment(this, rhs)

/**
 * Overload for more convenient usage with Kotlin strings.
 *
 * @param rhs The right hand side
 */
infix fun Variable.`=`(rhs: kotlin.String) = Assignment(this, String(rhs))

/**
 * Overload for more convenient usage with Kotlin numbers.
 *
 * @param rhs The right hand side
 */
infix fun Variable.`=`(rhs: kotlin.Number) = Assignment(this, Number(rhs))
