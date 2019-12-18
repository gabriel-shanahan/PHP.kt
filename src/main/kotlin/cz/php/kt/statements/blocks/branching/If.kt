package cz.php.kt.statements.blocks.branching

import cz.php.kt.expressions.Expression
import cz.php.kt.statements.Statement

/**
 * The if statement
 */
class If(condition: Expression) : BranchingStatement(condition) {
    override val conditionName: String = "if"
}

/**
 * Helper function to create an if block with the body [exec]
 *
 * @param condition The condition of the if statement
 * @param exec The bod of the if statement
 */
inline fun Statement.`if`(condition: Expression, exec: If.() -> Unit) = If(condition).apply(exec)
