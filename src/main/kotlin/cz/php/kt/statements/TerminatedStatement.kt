package cz.php.kt.statements

import cz.php.kt.expressions.Expression

/**
 * A statement terminated by a semicolon. This statement contains a single [expression]. Whenever
 * [unaryPlus][cz.php.kt.statements.blocks.Block.unaryPlus] is called on an
 * [Expression][cz.php.kt.expressions.Expression], it is automatically wrapped in a TerminatedStatement.
 *
 * @param expression The expression to be terminated.
 */
data class TerminatedStatement(private val expression: Expression) : Statement() {
    override fun toPhpStr(): String = expression.toPhpStr() + ';'
}
