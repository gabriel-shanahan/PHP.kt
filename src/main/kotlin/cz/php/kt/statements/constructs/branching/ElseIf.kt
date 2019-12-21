package cz.php.kt.statements.constructs.branching

import cz.php.kt.expressions.Expression
import cz.php.kt.statements.CompoundStatement
import cz.php.kt.statements.blocks.Block
import cz.php.kt.statements.constructs.CodeConstruct

/**
 * The elseif statement
 *
 *  @param condition The condition expression in the elseif statement.
 */
class ElseIf(private val condition: Expression) : CodeConstruct(" ") {

    override val head: String get() = "elseif (${condition.toPhpStr()})"
    override val body: CompoundStatement = Block()
}
