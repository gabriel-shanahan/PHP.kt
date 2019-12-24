package com.github.gabrielshanahan.phpkt.statements.constructs.branching

import com.github.gabrielshanahan.phpkt.Expression
import com.github.gabrielshanahan.phpkt.statements.CompoundStatement
import com.github.gabrielshanahan.phpkt.statements.blocks.Block
import com.github.gabrielshanahan.phpkt.statements.constructs.CodeConstruct

/**
 * The elseif statement
 *
 *  @param condition The condition expression in the elseif statement.
 */
class ElseIf(private val condition: Expression) : CodeConstruct(" ") {

    override val head: String get() = "elseif (${condition.toPhpStr()})"
    override val body: CompoundStatement = Block()
}
