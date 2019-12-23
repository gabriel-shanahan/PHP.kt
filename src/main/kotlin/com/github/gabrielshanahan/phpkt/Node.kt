package com.github.gabrielshanahan.phpkt

/**
 * The base interface for all PHP objects. Exposes a [toPhpStr] method which is responsible for generating the PHP code.
 */
interface Node {
    /**
     * Responsible for generating valid PHP code.
     */
    fun toPhpStr(): String
}
