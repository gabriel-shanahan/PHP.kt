package cz.php.kt.statements.blocks

import cz.php.kt.Node
import cz.php.kt.expressions.Expression
import cz.php.kt.statements.Statement
import cz.php.kt.statements.TerminatedStatement

/**
 * Any code block, i.e. a statement that contains other statements. Most often this will be a code
 * block delimited by curly braces, but it also represents "case:" blocks in a switch statement, or the "<?php" block.
 *
 * Block splits its rendering into two parts, [renderHead] and [renderChildren]. It also defines a central part of the
 * DSL in the form of [unaryPlus], which allows adding Nodes as children of a given block.
 *
 * @param children The child statements of the code block.
 */
abstract class Block(protected val children: MutableList<Node> = mutableListOf()) : Statement() {

    /**
     * This is where the "head" of the block is rendered, eg. in a "for" statement, this would be the
     * for(...) part.
     */
    abstract fun renderHead(): String

    /**
     * This is where the children of the block are rendered. In a for or if statement, this would be the {...}
     */
    abstract fun renderChildren(): String

    /**
     * The separator between head and children. This is included for conformity with PSR-x standards - some
     * curly blocks must open on the same line as the head (if, for, ...), some on the next line
     * (function/class declarations).
     */
    abstract val headChildrenSeparator: String

    /**
     * Combines [renderHead] and [renderChildren] to produce the final PHP code
     */
    override fun toPhpStr(): String = renderHead() + headChildrenSeparator + renderChildren()

    /**
     * Appends the [Node] to the children of the Block in whose context this method is called. When appending an
     * [Expression], it is automatically transformed to a TerminatedStatement (to render the semicolon at the end).
     */
    operator fun Node.unaryPlus() {
        this@Block.children.add(
            if (this is Expression) TerminatedStatement(this) else this
        )
    }
}

/**
 * Renders the PHP code of every element, separated by newlines.
 */
fun List<Node>.toPhpStr(): String = joinToString("\n", transform = Node::toPhpStr)
