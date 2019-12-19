package cz.php.kt.statements.constructs

import cz.php.kt.statements.CompoundStatement

/**
 * Represents the top-level node of any PHP code.
 */
class Php : CodeConstruct("\n\n") {
    override val head: String = "<?php"
    override val body: CompoundStatement = CompoundStatement("\n")
}

/**
 * DSL function to create a piece of code prepended with "<?php".
 */
inline fun php(exec: CompoundStatement.() -> Unit) = Php().apply { body.exec() }
