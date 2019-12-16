package cz.php.kt

/**
 * Block implements a default render() method which prints children out as a { ... } block indented with 4 spaces.
 */
abstract class Block(children: List<Node>) : Node(children) {

    /**
     * Must be overridden by subclasses. This is where the "head" of the statement/expression is rendered, eg. in a for
     * statement, this would be the for(...) part. Don't add explicit newlines at the end, the code takes care of that.
     */
    abstract fun renderHead(): String

    /**
     * Renders the children as a block surrounded by curly braces and indented with 4 spaces.
     */
    private fun renderChildren(): String = "{\n" +
        children
            .joinToString("\n", transform = Node::render)
            .prependIndent() +
        "\n}"

    /**
     * Combines [renderHead] and [renderChildren] to produce a string in the form "<renderHead> { <[children]> } with
     * appropriate newlines.
     */
    override fun render(): String = renderHead() + if (children.isNotEmpty()) "\n" + renderChildren() else ""
}
