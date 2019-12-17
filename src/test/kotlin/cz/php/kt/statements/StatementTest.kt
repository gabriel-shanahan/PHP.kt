package cz.php.kt.statements

import cz.php.kt.Node
import cz.php.kt.expressions.phpVar
import cz.php.kt.expressions.scalars.phpObj
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class StatementTest : StringSpec({

    class StringNode(val name: String) : Node(mutableListOf()) {
        override fun toPhpStr(): String = name
    }

    class Container(children: List<Node>) : Statement() {
        init {
            children.forEach {
                +it
            }
        }

        override fun toPhpStr(): String = children.joinToString(" ", transform = Node::toPhpStr)
    }

    "Unary plus correctly appends children" {
        val code = Container(listOf(StringNode("Hello"), StringNode("World"))).toPhpStr()

        code shouldBe "Hello World"
    }

    "Unary plus converts expressions to semicolon terminated statements" {
        val code = Container(listOf("Hello".phpVar, "World".phpObj)).toPhpStr()

        code shouldBe "\$Hello; \"World\";"
    }
})
