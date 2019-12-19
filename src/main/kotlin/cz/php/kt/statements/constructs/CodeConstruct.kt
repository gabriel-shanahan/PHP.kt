package cz.php.kt.statements.constructs

import cz.php.kt.statements.CompoundStatement
import cz.php.kt.statements.Statement

/**
 * Represents a PHP code construct, such as for, if, try, catch, finally, case, function declarations etc. A code
 * construct is defined by it's [head] and [body], separated by [neck], which is a whitespace separator. The [neck] is
 * used to implement PSR standards - some curly blocks must open on the same line as the head (e. g. if, for), some on
 * the next line (e.g. function/class declarations).
 *
 * @param neck The whitespace separator between the head and the body of the construct.
 */
abstract class CodeConstruct(private val neck: String) : Statement() {

    /**
     * The "head" of the construct, e.g. in a "for" statement, this would be the "for(...)" part.
     */
    abstract val head: String

    /**
     * The "body" of the construct, e.g. in a "for" statement, this would be the "{ ... }" part
     */
    abstract val body: CompoundStatement

    override fun toPhpStr(): String = head + neck + body.toPhpStr()
}
