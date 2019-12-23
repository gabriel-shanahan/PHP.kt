package com.github.gabrielshanahan.phpkt.statements

import com.github.gabrielshanahan.phpkt.Node

/**
 * All language constructs that do not evaluate to values, i.e. that are not an
 * [Expression][com.github.gabrielshanahan.phpkt.expressions.Expression]. This includes all code blocks, such as if, for, switch and
 * the base <?php block, but also semicolon-terminated statements.
 */
abstract class Statement : Node
