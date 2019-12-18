package cz.php.kt.statements

import cz.php.kt.Node

/**
 * All language constructs that do not evaluate to values, i.e. that are not an
 * [Expression][cz.php.kt.expressions.Expression]. This includes all code blocks, such as if, for, switch and
 * the base <?php block, but also semicolon-terminated statements.
 */
abstract class Statement : Node
