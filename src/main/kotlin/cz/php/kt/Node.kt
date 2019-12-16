package cz.php.kt

/**
 * The base class for all PHP tags. Has [children], which are Nodes themselves, and defines a render() method which
 * is responsible for generating the PHP code.
 */
abstract class Node(protected val children: MutableList<Node> = mutableListOf()) {

    /**
     * Generates the PHP code. Must be overridden by subclasses.
     */
    abstract fun asPhp(): String

    /**
     * Helper method that allows concise adding of children to a parent Node in builder functions.
     */
    operator fun Node.unaryPlus() {
        this@Node.children.add(this)
    }
}

/**
 * Helper method that allows concise rendering of lists of Nodes.
 */
fun List<Node>.asPhp(): String = joinToString("\n", transform = Node::asPhp)
