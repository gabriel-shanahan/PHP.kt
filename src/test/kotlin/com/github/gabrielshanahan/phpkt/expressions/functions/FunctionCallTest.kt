package com.github.gabrielshanahan.phpkt.expressions.functions

import com.github.gabrielshanahan.phpkt.expressions.assignables.`$`
import com.github.gabrielshanahan.phpkt.expressions.scalars.phpObj
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class FunctionCallTest : StringSpec({
    val functionCall = FunctionCall("test", listOf("one".phpObj, "two".phpObj, 3.phpObj, `$`("four")))

    "Function calls render as expected" {
        functionCall.toPhpStr() shouldBe """test("one", "two", 3, ${'$'}four)"""
    }

    "Iterative building up of functions works" {
        "test" `$` "one".phpObj `,` "two" `,` 3 `,` `$`("four") shouldBe functionCall
    }
})
