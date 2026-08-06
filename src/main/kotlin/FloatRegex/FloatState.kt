abstract class FloatState(protected val detector: FloatRegex) : State {
    companion object {
        fun isNonZeroDigit(character: String): Boolean = character in "123456789"

        fun isDigit(character: String): Boolean = character in "0123456789"

        fun isPeriod(character: String): Boolean = character == "."
    }
}
