package cz.php.kt.statements.blocks

import cz.php.kt.statements.CompoundStatement

/**
 * A code block delimited by curly braces and indented with 4 spaces.
 */
class Block : CompoundStatement("\n") {

    /**
     * Renders the children as a block surrounded by curly braces and indented with 4 spaces.
     */
    override fun toPhpStr(): String = "{" +
        (if (children.isNotEmpty()) "\n" + children.joinToPhpString().prependIndent() + "\n" else "") +
        "}"
}
