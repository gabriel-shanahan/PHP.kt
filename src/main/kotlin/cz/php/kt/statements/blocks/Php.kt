package cz.php.kt.statements.blocks

/**
 * Represents the top-level node of any PHP code. Other classes define the PHP DSL by adding extension methods to this
 * object, which correspond to the code they generate.
 */
class Php : Block() {
    override fun renderHead(): String = "<?php"

    override val headChildrenSeparator: String = "\n\n"

    override fun renderChildren(): String = children.toPhpStr()
}

/**
 * DSL function to create a piece of code prepended with "<?php". The rest of the code is generated in [exec].
 */
inline fun php(exec: Php.() -> Unit) = Php().apply(exec)
