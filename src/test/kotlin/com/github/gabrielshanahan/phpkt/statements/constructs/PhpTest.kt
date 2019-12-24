package com.github.gabrielshanahan.phpkt.statements.constructs

import com.github.gabrielshanahan.phpkt.Statement
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class PhpTest : StringSpec({

    class StringNode(val name: String) : Statement() {
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
