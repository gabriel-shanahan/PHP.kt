package com.github.gabrielshanahan.phpkt.statements.constructs.branching

import com.github.gabrielshanahan.phpkt.statements.CompoundStatement
import com.github.gabrielshanahan.phpkt.statements.blocks.Block
import com.github.gabrielshanahan.phpkt.statements.constructs.CodeConstruct

/**
 * The else statement
 */
class Else : CodeConstruct(" ") {
    override val head: String = "else"
    override val body: CompoundStatement = Block()
}
