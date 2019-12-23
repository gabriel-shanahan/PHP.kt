package com.github.gabrielshanahan.phpkt.statements.blocks

import com.github.gabrielshanahan.phpkt.expressions.scalars.phpObj
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class BlockTest : StringSpec({
    "A code block renders as expected" {

        val code = Block().apply {
            +"0".phpObj
            +"1".phpObj
        }.toPhpStr()

        val expected = """
            |{
            |    "0";
            |    "1";
            |}""".trimMargin()

        code shouldBe expected
    }

    "Nested code blocks render as expected" {
        val code = Block().apply {
            +0.phpObj
            +Block().apply {
                +"0".phpObj
                +"1".phpObj
            }
            +1.phpObj
        }.toPhpStr()

        val expected = """
            |{
            |    0;
            |    {
            |        "0";
            |        "1";
            |    }
            |    1;
            |}""".trimMargin()

        code shouldBe expected
    }

    "Empty block renders brackets on the same line" {
        Block().toPhpStr() shouldBe "{}"

        Block().apply {
            +Block()
        }.toPhpStr() shouldBe """
            |{
            |    {}
            |}
        """.trimMargin()
    }
})
