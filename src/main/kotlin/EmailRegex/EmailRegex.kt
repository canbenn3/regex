class EmailRegex : RegexStateMachine() {
    override var currentState: State = createInitialState()

    override fun resetState() {
        currentState = createInitialState()
    }

    override fun isMatch(value: String): Boolean = currentState is ValidEmail

    private fun createInitialState(): State = LookingForFirstEmailChar(this)
}
