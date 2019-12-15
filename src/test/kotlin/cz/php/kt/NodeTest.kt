package cz.php.kt

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class NodeTest : StringSpec({
    class StringNode(val name: String) : Node(emptyList()) {
        override fun renderSelf(): String = name
    }

    class MockNode(val name: String, children: List<Node>) : Node(children) {
        override fun renderSelf(): String = name
    }

    "A node should indent it's children properly" {
        val expectedFlat = """
            |for()
            |{
            |    0
            |    1
            |}""".trimMargin()

        val expectedNested = """
            |for()
            |{
            |    for()
            |    {
            |        0
            |        1
            |    }
            |    1
            |}""".trimMargin()

        val strings = List(2) {
            StringNode(it.toString())
        }

        val mockFor = MockNode("for()", strings)

        mockFor.toString() shouldBe expectedFlat
        MockNode("for()", listOf(mockFor, StringNode("1"))).toString() shouldBe expectedNested
    }
})
