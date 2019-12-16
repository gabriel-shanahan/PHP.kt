package cz.php.kt

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class NodeTest : StringSpec({
    class StringNode(val name: String) : Node(emptyList()) {
        override fun asPhp(): String = name
    }

    "Rendering a list of nodes renders each one on a separate line" {
        val nodes = List(3) { StringNode(it.toString()) }

        nodes.asPhp() shouldBe "0\n1\n2"
    }
})
