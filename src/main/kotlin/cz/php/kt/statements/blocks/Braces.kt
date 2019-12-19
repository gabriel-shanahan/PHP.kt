package cz.php.kt.statements.blocks

/**
 * A code block delimited by curly braces.
 */
abstract class Braces : Block() {

    /**
     * Renders the children as a block surrounded by curly braces and indented with 4 spaces.
     *
     * With respect to PSR-x, there are two different situations that can arise - either the opening bracket is on the
     * same line as the [head][Block.renderHead] (if, for, try/catch, ...) or the opening bracket is on a separate line
     * (function/class definitions, ...). The [headChildrenSeparator][Block.headChildrenSeparator] is overridden in
     * subclasses to control this.
     */
    override fun renderChildren(): String = "{" +
        (if (children.isNotEmpty()) "\n" + children.joinToPhpString().prependIndent() + "\n" else "") +
            "}"
}
