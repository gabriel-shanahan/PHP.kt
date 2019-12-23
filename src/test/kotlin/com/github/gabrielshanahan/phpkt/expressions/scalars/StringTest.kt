package com.github.gabrielshanahan.phpkt.expressions.scalars

import io.kotlintest.properties.assertAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class StringTest : StringSpec({
    "Strings are printed as-is" {
        assertAll { str: kotlin.String ->
            String(str).toPhpStr() shouldBe "\"$str\""
        }
    }

    "Kotlin strings are correctly converted to PHP String objects" {
        assertAll { str: kotlin.String ->
            str.phpObj shouldBe String(str)
        }
    }
})
