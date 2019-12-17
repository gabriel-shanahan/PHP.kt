package cz.php.kt.statements

import cz.php.kt.expressions.asPhpVar
import cz.php.kt.expressions.assignments.`=`
import cz.php.kt.expressions.scalars.asPhpObj
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class TerminatedStatementTest : StringSpec({
    "Terminated statements append a semicolon to expressions" {
        val expr = "x".asPhpVar() `=` 3.14.asPhpObj()
        TerminatedStatement(expr).toPhpStr() shouldBe expr.toPhpStr() + ";"
    }
})
