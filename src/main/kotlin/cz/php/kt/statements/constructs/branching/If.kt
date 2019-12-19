package cz.php.kt.statements.constructs.branching

import cz.php.kt.FollowUpContext
import cz.php.kt.expressions.Expression
import cz.php.kt.statements.CompoundStatement
import cz.php.kt.statements.blocks.Block
import cz.php.kt.statements.constructs.CodeConstruct

/**
 * The if statement
 *
 *  @param condition The condition expression in the if statement.
 */
class If(private val condition: Expression) : CodeConstruct(" ") {

    override val head: String get() = "if(${condition.toPhpStr()})"
    override val body: CompoundStatement = Block()
}

/**
 * DSL method to create an if block with the body [exec]. Since this block could possibly be followed by an elseif or
 * else block and PSR standards dictate they need to be separated from the if block by a space instead of a newline,
 * we need to create a [CompoundStatement] containing the if block, and add that to the receiver's children instead.
 * That way, if there is a follow-up elseif/else block, it gets added to the created CompoundStatement and rendered
 * according to PSR standards.
 *
 * @param condition The condition of the if statement
 * @param exec The body of the if statement
 *
 * @see IfFollowUp
 */
inline fun CompoundStatement.`if`(condition: Expression, exec: CompoundStatement.() -> Unit): IfFollowUp {
    val ifBlock = If(condition).apply { body.exec() }

    // PSR standards dictate that elseif/else blocks should start right after the closing "}" of the previous block, so
    // the separator is a space
    val ifElseCompoundStatement = CompoundStatement(" ", mutableListOf(ifBlock))
    +ifElseCompoundStatement
    return IfFollowUp(ifElseCompoundStatement)
}

/**
 * The applicable followups to if statements.
 */
class IfFollowUp(override val parent: CompoundStatement) : FollowUpContext {

    /**
     * DSL method to create an else block with the body [exec]
     *
     * @param exec The body of the else statement
     *
     * @see Else
     * @see if
     */
    inline infix fun `else`(exec: CompoundStatement.() -> Unit) = parent.apply {
        +Else().apply { body.exec() }
    }
}
