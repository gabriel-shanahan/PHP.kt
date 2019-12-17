package cz.php.kt.statements.blocks.branching

import cz.php.kt.expressions.Expression

/**
 * The if statement
 *
 */
class If(condition: Expression) : BranchingStatement(condition) {
    override val conditionName: String = "if"
}
