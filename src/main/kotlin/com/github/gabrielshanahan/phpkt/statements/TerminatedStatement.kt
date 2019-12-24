package com.github.gabrielshanahan.phpkt.statements

import com.github.gabrielshanahan.phpkt.Expression
import com.github.gabrielshanahan.phpkt.Statement

/**
 * A statement terminated by a semicolon. This statement contains a single [expression]. Whenever
 * [unaryPlus][com.github.gabrielshanahan.phpkt.statements.CompoundStatement.unaryPlus] is called on an
 * [Expression][com.github.gabrielshanahan.phpkt.Expression], it is automatically wrapped in a
 * TerminatedStatement.
 *
 * @param expression The expression to be terminated.
 */
data class TerminatedStatement(private val expression: Expression) : Statement() {
    override fun toPhpStr(): String = expression.toPhpStr() + ';'
}
