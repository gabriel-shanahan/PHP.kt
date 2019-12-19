package cz.php.kt.statements.blocks.branching

import cz.php.kt.statements.blocks.Braces

/**
 * The else statement
 */
class Else : Braces() {
    override fun renderHead(): String = "else"
}
