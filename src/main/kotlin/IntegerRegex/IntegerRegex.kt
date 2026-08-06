class IntegerRegex : RegexStateMachine() {
    override var currentState: State = createInitialState()

    override fun resetState() {
        currentState = createInitialState()
    }

    override fun isMatch(value: String): Boolean = currentState is ValidInteger

    private fun createInitialState(): State = LookingForFirstIntDigit(this)
}
