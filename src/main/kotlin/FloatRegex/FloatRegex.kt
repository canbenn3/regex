class FloatRegex : RegexStateMachine() {
    override var currentState: State = createInitialState()

    override fun resetState() {
        currentState = createInitialState()
    }

    override fun isMatch(value: String): Boolean = currentState is ValidFloat

    private fun createInitialState(): State = LookingForFirstFloatChar(this)
}
