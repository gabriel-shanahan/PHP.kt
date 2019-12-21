package cz.php.kt

import cz.php.kt.expressions.Expression
import cz.php.kt.statements.CompoundStatement
import cz.php.kt.statements.constructs.branching.IfElseIfFollowUp

/**
 * The purpose of [FollowUpContexts][FollowUpContext] is to allow one to define a set of functions that can only be
 * called in certain situations, e.g. an else block can only follow an if block. For constructs where such restrictions
 * apply, we define a FollowUpContext which defines the applicable "follow-up" functions, and then return instances of
 * it whenever necessary.
 *
 * @see cz.php.kt.statements.constructs.branching.If
 */
interface FollowUpContext {
    /**
     * The parent block. This reference is used so we have a way to add children in the DSL functions.
     *
     * @see [CompoundStatement.unaryPlus]
     */
    val parent: CompoundStatement
}

/**
 * Used as a hack to allow follow-up statements which also need a parameter (such as elseif() or catch()) to be used in
 * the same way as one would when writing PHP, i.e. on the same line as the closing bracket of the previous block,
 * without any additional special syntax.
 *
 * These function are defined as infix functions on the return value of the previous block (see. e.g.
 * [IfElseIfFollowUp.elseif] and [IfElseIfFollowUp]), but they need two parameters - one is the expression inside the
 * parentheses, such as the condition in an elseif statement, and the other is the actual [block], which is a lambda.
 * However, infix functions can naturally only have two parameters. We solve this by defining invoke on
 * [Expressions][Expression], which causes the [block] to be interpreted as a parameter to the invoke function of the
 * Expression, transforming both to a Pair, and thus allowing the infix function to be called with a single parameter.
 */
operator fun Expression.invoke(block: CompoundStatement.() -> Unit) = this to block
