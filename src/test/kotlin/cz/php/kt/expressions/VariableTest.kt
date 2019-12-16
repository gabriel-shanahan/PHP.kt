package cz.php.kt.expressions

import io.kotlintest.data.forall
import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row

class VariableTest : StringSpec({
    "Variables are printed correctly" {
        Variable("test1").asPhp() shouldBe "\$test1"
        Variable("_test1").asPhp() shouldBe "\$_test1"
    }

    "Variable names are checked accordingly" {
        val invalidStart = { name: String ->
            row(name, "Variable names must start with a letter or underscore, but got $name.")
        }
        val invalidName = { name: String ->
            row(name, "Variable names can only contain letters, digits, or underscores, but got $name.")
        }

        forall(
            invalidStart("\$name"),
            invalidStart("3abc"),
            invalidName("a*3"),
            invalidName("b+5")
        ) { name, msg ->
            shouldThrow<Variable.InvalidVariableName> {
                Variable(name)
            }.message shouldBe msg
        }
    }
})
