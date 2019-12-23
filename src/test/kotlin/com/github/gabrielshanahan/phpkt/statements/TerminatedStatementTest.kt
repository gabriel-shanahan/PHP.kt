package com.github.gabrielshanahan.phpkt.statements

import com.github.gabrielshanahan.phpkt.expressions.`$`
import com.github.gabrielshanahan.phpkt.expressions.assignments.`=`
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class TerminatedStatementTest : StringSpec({
    "Terminated statements append a semicolon to expressions" {
        val expr = `$`("x") `=` 3.14
        TerminatedStatement(expr).toPhpStr() shouldBe expr.toPhpStr() + ";"
    }
})
