package cz.php.kt

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class PhpTest : StringSpec({

    class StringNode(val name: String) : Node(mutableListOf()) {
        override fun asPhp(): String = name
    }

    "The php function should add <?php at the beginning of the code" {
        val code = php {
            +StringNode("first")
        }.asPhp()

        code shouldBe "<?php\n\nfirst"
    }
})
