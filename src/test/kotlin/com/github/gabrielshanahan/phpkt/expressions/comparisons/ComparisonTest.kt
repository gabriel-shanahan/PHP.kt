package com.github.gabrielshanahan.phpkt.expressions.comparisons

import com.github.gabrielshanahan.phpkt.expressions.`$`
import com.github.gabrielshanahan.phpkt.expressions.scalars.phpObj
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class ComparisonTest : StringSpec({
    val x = `$`("x")
    val five = 5.phpObj
    val hello = "hello".phpObj

    "Comparisons render as expected" {
        Equal(x, five).toPhpStr() shouldBe """${'$'}x == 5"""
        NotEqual(x, five).toPhpStr() shouldBe """${'$'}x != 5"""
        LessThan(x, five).toPhpStr() shouldBe """${'$'}x < 5"""
        LessThanOrEqual(x, five).toPhpStr() shouldBe """${'$'}x <= 5"""
        GreaterThan(x, five).toPhpStr() shouldBe """${'$'}x > 5"""
        GreaterThanOrEqual(x, five).toPhpStr() shouldBe """${'$'}x >= 5"""
    }

    "Equal helper functions work as expected" {
        (x `==` five) shouldBe Equal(x, five)
        (x `==` 5) shouldBe Equal(x, five)
        (5 `==` x) shouldBe Equal(five, x)
        (x `==` "hello") shouldBe Equal(x, hello)
        ("hello" `==` x) shouldBe Equal(hello, x)
    }

    "NotEqual helper functions work as expected" {
        (x `!=` five) shouldBe NotEqual(x, five)
        (x `!=` 5) shouldBe NotEqual(x, five)
        (5 `!=` x) shouldBe NotEqual(five, x)
        (x `!=` "hello") shouldBe NotEqual(x, hello)
        ("hello" `!=` x) shouldBe NotEqual(hello, x)
    }

    "LessThan helper functions work as expected" {
        (x lt five) shouldBe LessThan(x, five)
        (x lt 5) shouldBe LessThan(x, five)
        (5 lt x) shouldBe LessThan(five, x)
        (x lt "hello") shouldBe LessThan(x, hello)
        ("hello" lt x) shouldBe LessThan(hello, x)
    }

    "LessThanOrEqual helper functions work as expected" {
        (x lte five) shouldBe LessThanOrEqual(x, five)
        (x lte 5) shouldBe LessThanOrEqual(x, five)
        (5 lte x) shouldBe LessThanOrEqual(five, x)
        (x lte "hello") shouldBe LessThanOrEqual(x, hello)
        ("hello" lte x) shouldBe LessThanOrEqual(hello, x)
    }

    "GreaterThan helper functions work as expected" {
        (x gt five) shouldBe GreaterThan(x, five)
        (x gt 5) shouldBe GreaterThan(x, five)
        (5 gt x) shouldBe GreaterThan(five, x)
        (x gt "hello") shouldBe GreaterThan(x, hello)
        ("hello" gt x) shouldBe GreaterThan(hello, x)
    }

    "GreaterThanOrEqual helper functions work as expected" {
        (x gte five) shouldBe GreaterThanOrEqual(x, five)
        (x gte 5) shouldBe GreaterThanOrEqual(x, five)
        (5 gte x) shouldBe GreaterThanOrEqual(five, x)
        (x gte "hello") shouldBe GreaterThanOrEqual(x, hello)
        ("hello" gte x) shouldBe GreaterThanOrEqual(hello, x)
    }
})
