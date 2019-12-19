package cz.php.kt.statements.blocks

/**
 * Represents the top-level node of any PHP code.
 */
class Php : CompoundStatement() {

    override fun toPhpStr(): String = "<?php\n\n${children.joinToPhpString()}"
}

/**
 * DSL function to create a piece of code prepended with "<?php".
 */
inline fun php(exec: Php.() -> Unit) = Php().apply(exec)
