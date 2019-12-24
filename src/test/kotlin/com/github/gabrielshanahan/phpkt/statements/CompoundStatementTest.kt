package com.github.gabrielshanahan.phpkt.statements

import com.github.gabrielshanahan.phpkt.Statement
import com.github.gabrielshanahan.phpkt.expressions.assignables.`$`
import com.github.gabrielshanahan.phpkt.expressions.scalars.phpObj
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class CompoundStatementTest : StringSpec({
    class StringNode(val name: String) : Statement() {
        override fun toPhpStr(): String = name
    }

    "Rendering a CompoundStatement renders each children separated by the separator" {
        val nodes = CompoundStatement(" ", MutableList(3) { StringNode(it.toString()) })

        nodes.toPhpStr() shouldBe "0 1 2"
    }

    "Unary plus correctly appends children" {
        val code = CompoundStatement(" ").apply {
            +StringNode("Hello")
            +StringNode("World")
        }.toPhpStr()

        code shouldBe "Hello World"
    }

    "Unary plus converts expressions to semicolon terminated statements" {
        val code = CompoundStatement(" ").apply {
            +`$`("Hello")
            +"World".phpObj
        }.toPhpStr()

        code shouldBe "\$Hello; \"World\";"
    }
})
