package com.github.gabrielshanahan.phpkt.expressions

import com.github.gabrielshanahan.phpkt.Node

/**
 * A Node that evaluates to a specific value in PHP, i.e. it is not a statement. Examples are primitive
 * values, assignments, function calls etc.
 */
abstract class Expression : Node
