package cz.php.kt.statements.blocks.branching

import cz.php.kt.expressions.Expression
import cz.php.kt.statements.blocks.Braces

/**
 * The base class for all branching statements (if, else, switch, ...)
 *
 * @param condition The condition expression in the branching statement.
 */
abstract class BranchingStatement(private val condition: Expression) : Braces() {
    /**
     * The name of the branching statement
     */
    abstract val conditionName: String

    override fun renderHead(): String = "$conditionName(${condition.toPhpStr()})"
}
