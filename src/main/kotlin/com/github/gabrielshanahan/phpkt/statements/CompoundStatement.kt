package com.github.gabrielshanahan.phpkt.statements

import com.github.gabrielshanahan.phpkt.Node
import com.github.gabrielshanahan.phpkt.expressions.Expression
import com.github.gabrielshanahan.phpkt.expressions.assignables.Variable
import com.github.gabrielshanahan.phpkt.expressions.assignments.Assignment
import com.github.gabrielshanahan.phpkt.expressions.scalars.Number
import com.github.gabrielshanahan.phpkt.expressions.scalars.String

/**
 * Any compound statement, i.e. a statement that contains other statements. Most often this will be a code
 * block, but it also represents "case:" blocks in a switch statement, or the "<?php" block.
 *
 * Most of the DSL is defined here.
 *
 * @param separator The whitespace that will separate the children.
 * @param children The child statements of the compound statement.
 */
open class CompoundStatement(
    protected open val separator: kotlin.String,
    protected val children: MutableList<Node> = mutableListOf()
) : Statement() {

    /**
     * Appends the [Node] to the children of the Block in whose context this method is called. When appending an
     * [Expression], it is automatically transformed to a TerminatedStatement (to render the semicolon at the end).
     */
    operator fun Node.unaryPlus() {
        this@CompoundStatement.children.add(
            if (this is Expression) TerminatedStatement(this) else this
        )
    }

    /**
     * Renders the PHP code of every [child][Node], separated by [separator].
     */
    fun List<Node>.joinToPhpString(): kotlin.String = joinToString(separator, transform = Node::toPhpStr)

    override fun toPhpStr(): kotlin.String = children.joinToPhpString()

    /**
     * DSL method for assignments
     *
     * @param rhs The right hand side
     */
    infix fun Variable.`=`(rhs: Expression) = +Assignment(this, rhs)

    /**
     * Overload for Strings
     *
     * @param rhs The right hand side
     */
    infix fun Variable.`=`(rhs: kotlin.String) = +Assignment(this, String(rhs))

    /**
     * Overload for Numbers
     *
     * @param rhs The right hand side
     */
    infix fun Variable.`=`(rhs: kotlin.Number) = +Assignment(this, Number(rhs))
}
