package cz.php.kt.statements.constructs.branching

import cz.php.kt.expressions.assignments.`=`
import cz.php.kt.expressions.phpVar
import cz.php.kt.expressions.scalars.phpObj
import cz.php.kt.statements.CompoundStatement
import cz.php.kt.statements.constructs.php
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class IfElseTest : StringSpec({

    fun CompoundStatement.createChildren(): CompoundStatement {
        +("y".phpVar `=` "x is true".phpObj)
        +("z".phpVar `=` "x is true".phpObj)
        return this
    }

    "An if block renders correctly" {
        val code = If("x".phpVar)
            .apply { body.createChildren() }
            .toPhpStr()

        val expected = """
            |if(${'$'}x) {
            |    ${'$'}y = "x is true";
            |    ${'$'}z = "x is true";
            |}""".trimMargin()

        code shouldBe expected
    }

    "`if` DSL method works correctly" {
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

    "`else` DSL method can be called after `if` and renders correctly" {
        val code = php {
            `if`("x".phpVar) {
                +("y".phpVar `=` 5.phpObj)
            } `else` {
                +("x".phpVar `=` 5.phpObj)
            }
        }.toPhpStr()

        val expected = """
            |<?php
            |
            |if(${'$'}x) {
            |    ${'$'}y = 5;
            |} else {
            |    ${'$'}x = 5;
            |}
        """.trimMargin()

        code shouldBe expected
    }
})
