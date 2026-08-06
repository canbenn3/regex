abstract class RegexStateMachine : Regex {
    protected abstract var currentState: State

    final override fun matches(value: String): Boolean {
        resetState()
        splitIntoCharacters(value).forEach { currentState.consume(it) }
        return isMatch(value)
    }

    protected abstract fun resetState()

    protected abstract fun isMatch(value: String): Boolean

    fun changeState(newState: State) {
        currentState = newState
    }

    private fun splitIntoCharacters(value: String): List<String> = value.map { it.toString() }
}
