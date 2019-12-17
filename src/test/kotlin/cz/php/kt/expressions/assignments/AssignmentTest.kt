package cz.php.kt.expressions.assignments

import cz.php.kt.expressions.asPhpVar
import cz.php.kt.expressions.scalars.asPhpObj
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class AssignmentTest : StringSpec({

    "Assignments render correctly" {
        Assignment("x".asPhpVar(), "x".asPhpObj()).toPhpStr() shouldBe "\$x = \"x\""
    }

    "Helper function creates assignments correctly" {
        ("x".asPhpVar() `=` 3.14.asPhpObj()) shouldBe Assignment("x".asPhpVar(), 3.14.asPhpObj())
    }
})
