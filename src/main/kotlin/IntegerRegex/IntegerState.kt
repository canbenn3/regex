abstract class IntegerState(protected val detector: IntegerRegex) : State {
    companion object {
        fun isNonZeroDigit(character: String): Boolean = character in "123456789"

        fun isDigit(character: String): Boolean = character in "0123456789"
    }
}
