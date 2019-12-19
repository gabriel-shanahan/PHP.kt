package cz.php.kt.statements.blocks

import cz.php.kt.Node
import cz.php.kt.expressions.phpVar
import cz.php.kt.expressions.scalars.phpObj
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class BlockTest : StringSpec({
    class StringNode(val name: String) : Node {
        override fun toPhpStr(): String = name
    }

    "Rendering a list of nodes renders each one on a separate line" {
        val nodes = List(3) { StringNode(it.toString()) }

        nodes.toPhpStr() shouldBe "0\n1\n2"
    }

    class Container(children: List<Node>) : Block() {
        init {
            children.forEach {
                +it
            }
        }

        override fun renderHead(): String = ""

        override fun renderChildren(): String = children.joinToString(" ", transform = Node::toPhpStr)
        override val headChildrenSeparator: String = ""
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
