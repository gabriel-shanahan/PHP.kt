package cz.php.kt.statements.blocks

import cz.php.kt.Node
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class PhpTest : StringSpec({

    class StringNode(val name: String) : Node {
        override fun toPhpStr(): String = name
    }

    "The `php` dsl function should add <?php at the beginning of the code" {
        val code = php {
            +StringNode("first")
            +StringNode("second")
        }.toPhpStr()

        code shouldBe "<?php\n\nfirst\nsecond"
    }
})
