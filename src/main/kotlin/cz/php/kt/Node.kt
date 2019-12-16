package cz.php.kt

/**
 * The base class for all PHP tags. Has [children], which are Nodes themselves, and defines a render() method which
 * is responsible for generating the PHP code.
 */
abstract class Node(protected val children: List<Node>) {

    /**
     * Generates the PHP code. Must be overridden by subclasses.
     */
    abstract fun render(): String
}
