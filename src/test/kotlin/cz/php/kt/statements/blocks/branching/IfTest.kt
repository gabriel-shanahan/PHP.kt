package cz.php.kt.statements.blocks.branching

import cz.php.kt.expressions.assignments.`=`
import cz.php.kt.expressions.phpVar
import cz.php.kt.expressions.scalars.phpObj
import cz.php.kt.statements.blocks.php
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class IfTest : StringSpec({

    fun If.createChildren(): If {
        +("y".phpVar `=` "x is true".phpObj)
        +("z".phpVar `=` "x is true".phpObj)
        return this
    }

    "if renders correctly" {
        val code = If("x".phpVar)
            .createChildren()
            .toPhpStr()

        val expected = """
            |if(${'$'}x) {
            |    ${'$'}y = "x is true";
            |    ${'$'}z = "x is true";
            |}""".trimMargin()

        code shouldBe expected
    }

    "the if helper function works correctly" {
        val code = php {
            `if`("x".phpVar) {
                +("y".phpVar `=` 5.phpObj)
            }
        }.toPhpStr()

        val expected = """
            |<?php
            |
            |if(${'$'}x) {
            |    ${'$'}y = 5;
            |}
        """.trimMargin()

        code shouldBe expected
    }
})
