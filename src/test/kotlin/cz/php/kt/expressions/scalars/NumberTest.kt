package cz.php.kt.expressions.scalars

import io.kotlintest.properties.assertAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class NumberTest : StringSpec({
    "Numbers are printed as-is" {
        assertAll { num: Double ->
            Number(num).asPhp() shouldBe "$num"
        }

        assertAll { num: Long ->
            Number(num).asPhp() shouldBe "$num"
        }
    }

    "Kotlin numbers are correctly converted to PHP Number objects" {
        assertAll { num: Double ->
            num.asPhpObj() shouldBe Number(num)
        }

        assertAll { num: Long ->
            num.asPhpObj() shouldBe Number(num)
        }
    }
})
