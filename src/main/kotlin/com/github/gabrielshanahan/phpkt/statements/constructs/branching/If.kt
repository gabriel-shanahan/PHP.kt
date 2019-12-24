package com.github.gabrielshanahan.phpkt.statements.constructs.branching

import com.github.gabrielshanahan.phpkt.Expression
import com.github.gabrielshanahan.phpkt.statements.CompoundStatement
import com.github.gabrielshanahan.phpkt.statements.blocks.Block
import com.github.gabrielshanahan.phpkt.statements.constructs.CodeConstruct

/**
 * The if statement
 *
 *  @param condition The condition expression in the if statement.
 */
class If(private val condition: Expression) : CodeConstruct(" ") {
    override val head: String get() = "if (${condition.toPhpStr()})"
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
 * @see IfElseIfFollowUp
 */
inline fun CompoundStatement.`if`(condition: Expression, exec: CompoundStatement.() -> Unit): IfElseIfFollowUp {
    val ifBlock = If(condition).apply { body.exec() }

    // PSR standards dictate that elseif/else blocks should start right after the closing "}" of the previous block, so
    // the separator is a space
    val ifElseCompoundStatement = CompoundStatement(" ", mutableListOf(ifBlock))
    +ifElseCompoundStatement
    return IfElseIfFollowUp(ifElseCompoundStatement)
}
