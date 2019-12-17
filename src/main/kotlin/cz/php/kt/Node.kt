package cz.php.kt

/**
 * The base class for all PHP tags. Has [children], which are Nodes themselves, and defines a render() method which
 * is responsible for generating the PHP code.
 *
 * @param children The children of this Node.
 */
abstract class Node(protected open val children: MutableList<Node> = mutableListOf()) {

    /**
     * Generates the PHP code. Must be overridden by subclasses.
     */
    abstract fun toPhpStr(): String

    /**
     * Helper method that allows concise adding of children to a parent Node in builder functions.
     * TODO: Probably move to Block, no sense in adding to children where there aren't any. It should check if [this] is
     * TODO: an expression, and if so, add a semicolon to the end.
     */
    operator fun Node.unaryPlus() {
        this@Node.children.add(this)
    }
}

/**
 * Helper method that allows concise rendering of lists of Nodes.
 */
fun List<Node>.toPhpStr(): String = joinToString("\n", transform = Node::toPhpStr)
