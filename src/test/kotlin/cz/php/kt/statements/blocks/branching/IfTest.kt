package cz.php.kt.statements.blocks.branching

import cz.php.kt.expressions.asPhpVar
import cz.php.kt.expressions.assignments.`=`
import cz.php.kt.expressions.scalars.asPhpObj
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class IfTest : StringSpec({

    fun If.createChildren(): If {
        +("y".asPhpVar() `=` "x is true".asPhpObj())
        +("z".asPhpVar() `=` "x is true".asPhpObj())
        return this
    }

    "if renders correctly" {
        val code = If("x".asPhpVar())
            .createChildren()
            .toPhpStr()

        val expected = """
            |if(${'$'}x)
            |{
            |    ${'$'}y = "x is true";
            |    ${'$'}z = "x is true";
            |}""".trimMargin()

        code shouldBe expected
    }
})
