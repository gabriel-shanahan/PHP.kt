package cz.php.kt

import cz.php.kt.statements.blocks.Block
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class NodeTest : StringSpec({
    class StringNode(val name: String) : Node(mutableListOf()) {
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

        override fun renderHead(): String = "Container"
    }

    "Unary plus correctly appends children" {
        val code = Container(listOf(StringNode("Hello"), StringNode("World")))
        val expected = """
            |Container
            |{
            |    Hello
            |    World
            |}""".trimMargin()

        code.toPhpStr() shouldBe expected
    }
})
