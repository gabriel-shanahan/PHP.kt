package cz.php.kt.statements.blocks

/**
 * A code block delimited by curly braces.
 */
abstract class Braces : Block() {

    /**
     * Renders the children as a block surrounded by curly braces and indented with 4 spaces. The opening curly brace is
     * printed on the same line as the statements head. We mustn't forget the space at the beginning, which separates it
     * from whatever [renderHead] returns (see [Block.toPhpStr]).
     */
    override fun renderChildren(): String = " {" +
        (if (children.isNotEmpty()) "\n" + children.toPhpStr().prependIndent() + "\n" else "") +
            "}"
}
