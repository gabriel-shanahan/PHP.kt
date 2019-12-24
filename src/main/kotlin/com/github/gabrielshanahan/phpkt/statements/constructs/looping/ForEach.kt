package com.github.gabrielshanahan.phpkt.statements.constructs.looping

import com.github.gabrielshanahan.phpkt.Expression
import com.github.gabrielshanahan.phpkt.expressions.assignables.SimpleVariable
import com.github.gabrielshanahan.phpkt.statements.CompoundStatement
import com.github.gabrielshanahan.phpkt.statements.blocks.Block
import com.github.gabrielshanahan.phpkt.statements.constructs.CodeConstruct

/**
 * The foreach statement in the form foreach($[iterable], $[key] => $[value])
 *
 * @param iterable The iterable to be iterated over
 * @param key The key variable
 * @param value The value variable
 *
 */
class ForEach(
    private val iterable: Expression,
    private val key: SimpleVariable,
    private val value: SimpleVariable
) : CodeConstruct(" ") {

    override val head: String get() = "foreach(${iterable.toPhpStr()} as ${key.toPhpStr()} => ${value.toPhpStr()})"
    override val body: CompoundStatement = Block()
}

/**
 * DSL method to create ForEach block with body [exec]
 *
 * @param iterable The iterable to be iterated over
 * @param key The key variable
 * @param value The value variable
 * @param body The body of the block
 */
inline fun CompoundStatement.foreach(
    iterable: Expression,
    key: SimpleVariable,
    value: SimpleVariable,
    exec: CompoundStatement.() -> Unit
) {
    +ForEach(iterable, key, value).apply { body.exec() }
}
