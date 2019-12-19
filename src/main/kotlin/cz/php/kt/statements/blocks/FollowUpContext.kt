package cz.php.kt.statements.blocks

/**
 * The purpose of [FollowUpContexts][FollowUpContext] is to allow one to define a set of functions that can only be
 * called in certain situations, e.g. an else block can only follow an if block. For constructs where such restrictions
 * apply, we define a FollowUpContext which defines the applicable "follow-up" functions, and then return instances of
 * it whenever necessary.
 *
 * @see cz.php.kt.statements.blocks.branching.If
 */
interface FollowUpContext {
    /**
     * The parent block. This reference is used so we have a way to add children in the DSL functions.
     *
     * @see [CompoundStatement.unaryPlus]
     */
    val parent: CompoundStatement
}
