package com.github.gabrielshanahan.phpkt.statements.constructs.looping

import com.github.gabrielshanahan.phpkt.expressions.assignables.`$`
import com.github.gabrielshanahan.phpkt.statements.constructs.php
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class ForEachTest : StringSpec({
    "ForEach renders as expected" {
        val code = ForEach(`$`("x"), `$`("y"), `$`("z")).toPhpStr()
        val expected = """foreach(${'$'}x as ${'$'}y => ${'$'}z) {}"""

        code shouldBe expected
    }

    "foreach dsl method works as expected" {
        val code = php {
            foreach(`$`("x"), `$`("y"), `$`("z")) {
            }
        }.toPhpStr()

        val expected = """
            |<?php
            |
            |foreach(${'$'}x as ${'$'}y => ${'$'}z) {}
        """.trimMargin()

        code shouldBe expected
    }
})
