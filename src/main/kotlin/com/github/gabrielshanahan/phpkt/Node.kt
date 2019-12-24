package com.github.gabrielshanahan.phpkt

/**
 * The base interface for all PHP objects. Exposes a [toPhpStr] method which is responsible for generating the PHP code.
 */
sealed class Node {
    /**
     * Responsible for generating valid PHP code.
     */
    abstract fun toPhpStr(): String
}

/**
 * All language constructs that do not evaluate to values, i.e. that are not an [Expression]. This includes all code
 * blocks, such as if, for, switch and the base <?php block, but also semicolon-terminated statements.
 */
abstract class Statement : Node()

/**
 * A Node that evaluates to a specific value in PHP, i.e. it is not a [Statement]. Examples are primitive
 * values, assignments, function calls etc.
 */
abstract class Expression : Node()
