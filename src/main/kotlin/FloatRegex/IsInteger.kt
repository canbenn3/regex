class IsInteger(detector: FloatRegex) : FloatState(detector) {
    override fun consume(character: String) {
        when {
            isDigit(character) -> detector.changeState(IsInteger(detector))
            isPeriod(character) -> detector.changeState(FoundPeriod(detector))
            else -> detector.changeState(InvalidFloat(detector))
        }
    }
}
