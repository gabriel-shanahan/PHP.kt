package cz.php.kt.statements

import cz.php.kt.Node
import cz.php.kt.expressions.Expression

/**
 * Represents all language constructs that are not an [Expression][cz.php.kt.expressions.Expression]
 */
abstract class Statement : Node() {

    /**
     * Helper method that allows concise adding of children to a parent Block in builder functions. If the Node being
     * appended is an Expression, it is transformed to a TerminatedStatement (to render the semicolon at the end).
     */
    operator fun Node.unaryPlus() = this@Statement.children.add(
        if (this is Expression) TerminatedStatement(this) else this
    )
}
