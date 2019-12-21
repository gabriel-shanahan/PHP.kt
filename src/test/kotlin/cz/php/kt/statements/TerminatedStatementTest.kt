package cz.php.kt.statements

import cz.php.kt.expressions.`$`
import cz.php.kt.expressions.assignments.`=`
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class TerminatedStatementTest : StringSpec({
    "Terminated statements append a semicolon to expressions" {
        val expr = `$`("x") `=` 3.14
        TerminatedStatement(expr).toPhpStr() shouldBe expr.toPhpStr() + ";"
    }
})
