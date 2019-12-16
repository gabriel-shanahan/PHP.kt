package cz.php.kt.expressions.scalars

import io.kotlintest.properties.assertAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class StringTest : StringSpec({
    "Strings are printed as-is" {
        assertAll { str: kotlin.String ->
            String(str).asPhp() shouldBe "\"$str\""
        }
    }

    "Kotlin strings are correctly converted to PHP string objects" {
        assertAll { str: kotlin.String ->
            str.asPhpObj().asPhp() shouldBe String(str).asPhp()
        }
    }
})
