package cz.php.kt.statements.constructs.branching

import cz.php.kt.expressions.`$`
import cz.php.kt.expressions.assignments.`=`
import cz.php.kt.invoke
import cz.php.kt.statements.CompoundStatement
import cz.php.kt.statements.constructs.php
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class IfElseTest : StringSpec({

    fun CompoundStatement.createChildren(): CompoundStatement {
        +(`$`("y") `=` "x is true")
        +(`$`("z")`=` "x is true")
        return this
    }

    "An if block renders correctly" {
        val code = If(`$`("x"))
            .apply { body.createChildren() }
            .toPhpStr()

        val expected = """
            |if (${'$'}x) {
            |    ${'$'}y = "x is true";
            |    ${'$'}z = "x is true";
            |}""".trimMargin()

        code shouldBe expected
    }

    "`if` DSL method works correctly" {
        val code = php {
            `if`(`$`("x")) {
                +(`$`("y") `=` 5)
            }
        }.toPhpStr()

        val expected = """
            |<?php
            |
            |if (${'$'}x) {
            |    ${'$'}y = 5;
            |}
        """.trimMargin()

        code shouldBe expected
    }

    "elseif DSL method can be called after `if` and renders correctly" {
        val code = php {
            `if`(`$`("x")) {
                +(`$`("y") `=` 5)
            } elseif(`$`("x")) {
                +(`$`("x") `=` 5)
            }
        }.toPhpStr()

        val expected = """
            |<?php
            |
            |if (${'$'}x) {
            |    ${'$'}y = 5;
            |} elseif (${'$'}x) {
            |    ${'$'}x = 5;
            |}
        """.trimMargin()

        code shouldBe expected
    }

    "`else` DSL method can be called after `if` and renders correctly" {
        val code = php {
            `if`(`$`("x")) {
                +(`$`("y") `=` 5)
            } `else` {
                +(`$`("x") `=` 5)
            }
        }.toPhpStr()

        val expected = """
            |<?php
            |
            |if (${'$'}x) {
            |    ${'$'}y = 5;
            |} else {
            |    ${'$'}x = 5;
            |}
        """.trimMargin()

        code shouldBe expected
    }

    "if, elseif and else can be called after each other" {
        val code = php {
            `if`(`$`("x")) {
                +(`$`("x") `=` 5)
            } elseif(`$`("y")) {
                +(`$`("y") `=` 5)
            } elseif(`$`("z")) {
                +(`$`("z") `=` 5)
            } `else` {
                +(`$`("x") `=` `$`("y"))
            }
        }.toPhpStr()

        val expected = """
            |<?php
            |
            |if (${'$'}x) {
            |    ${'$'}x = 5;
            |} elseif (${'$'}y) {
            |    ${'$'}y = 5;
            |} elseif (${'$'}z) {
            |    ${'$'}z = 5;
            |} else {
            |    ${'$'}x = ${'$'}y;
            |}
        """.trimMargin()

        code shouldBe expected
    }
})
