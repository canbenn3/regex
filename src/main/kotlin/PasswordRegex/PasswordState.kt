abstract class PasswordState(protected val detector: PasswordRegex) : State {
    companion object {
        const val SPECIAL_CHARACTERS = "!@#$%&*"

        fun isCapital(character: String): Boolean = character in "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

        fun isSpecial(character: String): Boolean = character in SPECIAL_CHARACTERS
    }
}
