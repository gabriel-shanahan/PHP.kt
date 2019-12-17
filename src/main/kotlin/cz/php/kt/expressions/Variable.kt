package cz.php.kt.expressions

/**
 * Represents a PHP variable with the name [name].
 *
 * Because PHP is messed-up, any byte sequence constitutes a valid PHP name using the ${} syntax. We consider this to be
 * borderline offensive black magic and do not support it, instead permitting only names consisting of alphanumeric
 * characters or underscores, with the additional condition that the first character cannot be a number.
 *
 * @param name The name of the variable.
 */
data class Variable(private val name: String) : Expression() {

    /**
     * Performs checks on the variable name. The first letter must be either a letter or an underscore, the rest must be
     * alphanumeric or an underscore.
     */
    init {
        if (!name.first().isLetter() && name.first() != '_') {
            throw InvalidVariableName("Variable names must start with a letter or underscore, but got $name.")
        }
        if (!name.all { it.isLetterOrDigit() || it == '_' }) {
            throw InvalidVariableName("Variable names can only contain letters, digits, or underscores, but got $name.")
        }
    }

    override fun asPhp(): String = "\$$name"

    /**
     * Thrown when an invalid variable name is passed to Variable constructor.
     *
     * @param msg The exception message.
     */
    class InvalidVariableName(msg: String) : Throwable(msg)
}

/**
 * Helper function to convert Kotlin strings to PHP Variable objects.
 */
fun String.asPhpVar(): Variable = Variable(this)
