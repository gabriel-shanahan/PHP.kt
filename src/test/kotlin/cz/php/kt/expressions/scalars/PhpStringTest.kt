package cz.php.kt.expressions.scalars

import io.kotlintest.properties.assertAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class PhpStringTest : StringSpec({
    "Strings are printed as-is" {
        assertAll { str: String ->
            PhpString(str).asPhp() shouldBe "\"$str\""
        }
    }

    "Kotlin strings are correctly converted to PHP string objects" {
        assertAll { str: String ->
            str.asPhpObj().asPhp() shouldBe PhpString(str).asPhp()
        }
    }
})
