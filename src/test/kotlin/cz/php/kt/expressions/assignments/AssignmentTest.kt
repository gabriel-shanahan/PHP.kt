package cz.php.kt.expressions.assignments

import cz.php.kt.expressions.phpVar
import cz.php.kt.expressions.scalars.phpObj
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class AssignmentTest : StringSpec({

    "Assignments render correctly" {
        Assignment("x".phpVar, "x".phpObj).toPhpStr() shouldBe "\$x = \"x\""
    }

    "Helper function creates assignments correctly" {
        ("x".phpVar `=` 3.14.phpObj) shouldBe Assignment("x".phpVar, 3.14.phpObj)
    }
})
