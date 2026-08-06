class BinaryRegex : RegexStateMachine() {
    override var currentState: State = createInitialState()

    override fun resetState() {
        currentState = createInitialState()
    }

    override fun isMatch(value: String): Boolean = currentState is One

    private fun createInitialState(): State = LookingForFirstBinaryDigit(this)
}
