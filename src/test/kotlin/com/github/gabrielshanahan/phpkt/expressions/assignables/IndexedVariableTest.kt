package com.github.gabrielshanahan.phpkt.expressions.assignables

import com.github.gabrielshanahan.phpkt.expressions.scalars.phpObj
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class IndexedVariableTest : StringSpec({
    "Indexed variables render as expected" {
        IndexedVariable("a", mutableListOf("b".phpObj)).toPhpStr() shouldBe """${'$'}a["b"]"""
        IndexedVariable("a", mutableListOf(null)).toPhpStr() shouldBe """${'$'}a[]"""
    }

    val x = `$`("x")
    "DSL for accessing array elements works" {
        x["a"] shouldBe IndexedVariable("x", mutableListOf("a".phpObj))
        x[3] shouldBe IndexedVariable("x", mutableListOf(3.phpObj))
        x[x] shouldBe IndexedVariable("x", mutableListOf(x))
        x["a"]["a"] shouldBe IndexedVariable("x", mutableListOf("a".phpObj, "a".phpObj))
        x[3][3] shouldBe IndexedVariable("x", mutableListOf(3.phpObj, 3.phpObj))
        x[x][x] shouldBe IndexedVariable("x", mutableListOf(x, x))
    }
})
