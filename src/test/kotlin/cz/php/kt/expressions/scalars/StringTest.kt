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

    "Kotlin strings are correctly converted to PHP String objects" {
        assertAll { str: kotlin.String ->
            str.asPhpObj() shouldBe String(str)
        }
    }
})
