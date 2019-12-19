package cz.php.kt.statements

import cz.php.kt.Node
import cz.php.kt.expressions.Expression

/**
 * Any compound statement, i.e. a statement that contains other statements. Most often this will be a code
 * block, but it also represents "case:" blocks in a switch statement, or the "<?php" block.
 *
 * A central part of the DSL is defined here, in the form of [unaryPlus], which allows adding Nodes as children of a
 * given compound statement.
 *
 * @param separator The whitespace that will separate the children.
 * @param children The child statements of the compound statement.
 */
open class CompoundStatement(
    protected open val separator: String,
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
    fun List<Node>.joinToPhpString(): String = joinToString(separator, transform = Node::toPhpStr)

    override fun toPhpStr(): String = children.joinToPhpString()
}
