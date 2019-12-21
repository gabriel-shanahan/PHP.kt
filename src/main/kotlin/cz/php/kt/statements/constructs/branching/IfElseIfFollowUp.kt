package cz.php.kt.statements.constructs.branching

import cz.php.kt.FollowUpContext
import cz.php.kt.expressions.Expression
import cz.php.kt.statements.CompoundStatement

/**
 * The applicable followups to if and elseif statements.
 */
class IfElseIfFollowUp(override val parent: CompoundStatement) : FollowUpContext {

    /**
     * DSL method to create an elseif block. The parent compound statement in this case is the compound statement
     * containing all if-elseif-else blocks. See [if ], where it is created. To be able to use this as an infix
     * function, both the condition and the body must be wrapped in a pair. See [cz.php.kt.invoke].
     *
     * @param input A pair containing the condition of the elseif statement and the body of the elseif statement
     *
     * @see ElseIf
     * @see cz.php.kt.invoke
     */
    infix fun elseif(input: Pair<Expression, CompoundStatement.() -> Unit>): IfElseIfFollowUp = parent.run {
        val (condition, block) = input
        +ElseIf(condition).apply { body.block() }
        IfElseIfFollowUp(parent)
    }

    /**
     * DSL method to create an else block with the body [block]. The parent compound statement in this case is the
     * compound statement containing all if-elseif-else blocks. See [if ], where it is created.
     *
     * @param block The body of the else statement
     *
     * @see Else
     */
    inline infix fun `else`(block: CompoundStatement.() -> Unit) {
        parent.apply {
            +Else().apply { body.block() }
        }
    }
}
