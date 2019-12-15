package cz.php.kt

/**
 * The base class for all PHP tags. Has [children], which are Nodes themselves
 *
 * Node implements a default toString() method, which prints children out as a { ... } block indented with 4 spaces.
 */
abstract class Node(private val children: List<Node>) {
    /**
     * Must be overridden by subclasses. This is where the "head" of the statement/expression is rendered, eg. in a for
     * statement, this would be the for(...) part. Don't add explicit newlines at the end, the code takes care of that.
     */
    abstract fun renderSelf(): String

    /**
     * Renders the children as a block surrounded by curly braces and indented with 4 spaces.
     */
    private fun renderChildren(): String = "{\n" + children.joinToString("\n").prependIndent() + "\n}"

    /**
     * Combines [renderSelf] and [renderChildren] to produce a string in the form "<renderSelf> { <[children]> } with
     * appropriate newlines.
     */
    override fun toString(): String =
        renderSelf() + if (children.isNotEmpty()) "\n" + renderChildren() else ""
}
