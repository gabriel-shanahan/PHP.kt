package cz.php.kt.statements.blocks.branching

import cz.php.kt.expressions.Expression
import cz.php.kt.statements.blocks.Block
import cz.php.kt.statements.blocks.FollowUpContext

/**
 * The if statement
 */
class If(condition: Expression) : BranchingStatement(condition) {
    override val conditionName: String = "if"
}

/**
 * The applicable followups to if statements.
 */
class IfFollowUp(override val parent: Block) : FollowUpContext {

    /**
     * DSL method to create an else block with the body [exec]
     */
    inline infix fun `else`(exec: Else.() -> Unit) = parent.apply {
        +Else().apply(exec)
    }
}

/**
 * DSL method to create an if block with the body [exec]
 *
 * @param condition The condition of the if statement
 * @param exec The bod of the if statement
 */
inline fun Block.`if`(condition: Expression, exec: If.() -> Unit): IfFollowUp {
    +If(condition).apply(exec)
    return IfFollowUp(this)
}
