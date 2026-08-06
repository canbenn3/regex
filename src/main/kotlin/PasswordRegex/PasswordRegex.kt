private const val MINIMUM_PASSWORD_LENGTH = 8

class PasswordRegex : RegexStateMachine() {
    override var currentState: State = createInitialState()

    override fun resetState() {
        currentState = createInitialState()
    }

    override fun isMatch(value: String): Boolean =
        value.length >= MINIMUM_PASSWORD_LENGTH && currentState is ValidPassword

    private fun createInitialState(): State = LookingForFirstPasswordChar(this)
}
