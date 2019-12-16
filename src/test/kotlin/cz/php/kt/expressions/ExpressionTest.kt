package cz.php.kt.expressions

import cz.php.kt.Node
import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import io.kotlintest.specs.StringSpec

class ExpressionTest : StringSpec({

    "Accessing children on Expressions throws" {
        shouldThrow<Expression.InvalidOperationException> {
            object : Expression() {
                override fun asPhp(): String = "MockExpression"
                fun returnChildren(): MutableList<Node> = children
            }.returnChildren()
        }.message shouldBe "Accessing children on an expression makes no sense."
    }
})
