package cz.php.kt.statements

import cz.php.kt.expressions.Expression

/**
 * Represents a statement terminated by a semicolon. This statement contains a single [expression], e.g. an assignment.
 *
 * @param expression The expression to be terminated.
 */
class TerminatedStatement(private val expression: Expression) : Statement() {
    override fun toPhpStr(): String = expression.toPhpStr() + ';'
}
