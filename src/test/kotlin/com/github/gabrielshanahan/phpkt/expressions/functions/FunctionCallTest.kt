package com.github.gabrielshanahan.phpkt.expressions.functions

import com.github.gabrielshanahan.phpkt.expressions.`$`
import com.github.gabrielshanahan.phpkt.expressions.scalars.phpObj
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class FunctionCallTest : StringSpec({
    val functionCall = FunctionCall("test", listOf("one".phpObj, 2.phpObj, `$`("three")))

    "Function calls render as expected" {
        functionCall.toPhpStr() shouldBe """test("one", 2, ${'$'}three)"""
    }

    "Iterative building up of functions works" {
        "test" `$` "one".phpObj `,` 2.phpObj `,` `$`("three") shouldBe functionCall
    }
})
