package cz.php.kt

/**
 * The base class for all PHP tags. Has [children], which are Nodes themselves, and defines a render() method which
 * is responsible for generating the PHP code.
 */
abstract class Node(protected val children: List<Node>) {

    /**
     * Generates the PHP code. Must be overridden by subclasses.
     */
    abstract fun asPhp(): String
}

/**
 * Helper method that allows concise rendering of children.
 */
fun List<Node>.asPhp(): String = joinToString("\n", transform = Node::asPhp)
