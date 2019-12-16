package cz.php.kt

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class BlockTest : StringSpec({
    class StringNode(val name: String) : Node(emptyList()) {
        override fun asPhp(): String = name
    }

    class MockFor(children: List<Node>) : Block(children) {
        override fun renderHead(): String = "for()"
    }

    "A block should indent it's children properly" {
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

        val mockFor = MockFor(strings)

        mockFor.asPhp() shouldBe expectedFlat
        MockFor(listOf(mockFor, StringNode("1"))).asPhp() shouldBe expectedNested
    }
})
