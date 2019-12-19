package cz.php.kt.statements.constructs.branching

import cz.php.kt.statements.CompoundStatement
import cz.php.kt.statements.blocks.Block
import cz.php.kt.statements.constructs.CodeConstruct

/**
 * The else statement
 */
class Else : CodeConstruct(" ") {
    override val head: String = "else"
    override val body: CompoundStatement = Block()
}
