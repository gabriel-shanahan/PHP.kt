package com.github.gabrielshanahan.phpkt.expressions.scalars

import io.kotlintest.properties.assertAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class NumberTest : StringSpec({
    "Numbers are printed as-is" {
        assertAll { num: Double ->
            Number(num).toPhpStr() shouldBe "$num"
        }

        assertAll { num: Long ->
            Number(num).toPhpStr() shouldBe "$num"
        }
    }

    "Kotlin numbers are correctly converted to PHP Number objects" {
        assertAll { num: Double ->
            num.phpObj shouldBe Number(num)
        }

        assertAll { num: Long ->
            num.phpObj shouldBe Number(num)
        }
    }
})
