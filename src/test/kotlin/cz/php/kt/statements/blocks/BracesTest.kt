package cz.php.kt.statements.blocks

import cz.php.kt.Node
import cz.php.kt.expressions.scalars.phpObj
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class BracesTest : StringSpec({

    class MockFor(children: MutableList<out Node> = mutableListOf()) : Braces() {
        init {
            children.forEach {
                +it
            }
        }

        override fun renderHead(): String = "for()"
        override val headChildrenSeparator: String = " "
    }

    "A block should indent its children properly" {
        val expectedFlat = """
            |for() {
            |    "0";
            |    "1";
            |}""".trimMargin()

        val strings = MutableList(2) {
            it.toString().phpObj
        }

        val mockFor = MockFor(strings)

        mockFor.toPhpStr() shouldBe expectedFlat

        val expectedNested = """
            |for() {
            |    0;
            |    for() {
            |        "0";
            |        "1";
            |    }
            |    1;
            |}""".trimMargin()

        MockFor(mutableListOf(0.phpObj, mockFor, 1.phpObj)).toPhpStr() shouldBe expectedNested
    }

    "An empty block renders the braces on the same line" {
        val expectedEmpty = """
            |for() {}
        """.trimMargin()
        MockFor().toPhpStr() shouldBe expectedEmpty
    }
})
