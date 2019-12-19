package cz.php.kt.statements.blocks

import cz.php.kt.statements.CompoundStatement

/**
 * A code block delimited by curly braces. Splits its rendering into two parts, [renderHead] and [renderChildren],
 * separated by [headChildrenSeparator].
 */
abstract class CodeBlock : CompoundStatement() {

    /**
     * This is where the "head" of the block is rendered, e.g. in a "for" statement, this would be the
     * for(...) part.
     */
    abstract fun renderHead(): String

    /**
     * The whitespace separator between head and children.
     *
     * This is used to implement PSR-x standards - some curly blocks must open on the same line as the head (e. g. if,
     * for), some on the next line (e.g. function/class declarations).
     */
    abstract val headChildrenSeparator: String

    /**
     * Renders the children as a block surrounded by curly braces and indented with 4 spaces.
     *
     * With respect to PSR-x, there are two different situations that can arise - either the opening bracket is on the
     * same line as the [head][renderHead] (if, for, try/catch, ...) or the opening bracket is on a separate line
     * (function/class definitions, ...). The [headChildrenSeparator][headChildrenSeparator] is overridden in
     * subclasses to control this.
     */
    private fun renderChildren(): String = "{" +
        (if (children.isNotEmpty()) "\n" + children.joinToPhpString().prependIndent() + "\n" else "") +
            "}"

    /**
     * Combines [renderHead], [headChildrenSeparator] and [renderChildren] to produce the final PHP code.
     */
    override fun toPhpStr(): String = renderHead() + headChildrenSeparator + renderChildren()
}
