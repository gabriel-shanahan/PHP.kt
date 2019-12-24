package com.github.gabrielshanahan.phpkt.expressions.assignables

/**
 * A PHP variable with the name [name], such as $a.
 *
 * See [Assignable] for all the logic.
 *
 * @param name The name of the variable.
 */
data class SimpleVariable(val name: String) : Assignable(name)

/**
 * Helper function to convert Kotlin strings to PHP Variable objects.
 */
fun `$`(name: String) = SimpleVariable(name)
