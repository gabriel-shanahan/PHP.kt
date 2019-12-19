package cz.php.kt.statements.blocks.branching

import cz.php.kt.statements.blocks.CodeBlock

/**
 * The else statement
 */
class Else : CodeBlock() {
    override fun renderHead(): String = "else"
    override val headChildrenSeparator: String = " "
}
