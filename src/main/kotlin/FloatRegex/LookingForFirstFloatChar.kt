class LookingForFirstFloatChar(detector: FloatRegex) : FloatState(detector) {
    override fun consume(character: String) {
        when {
            character == "0" -> detector.changeState(FirstDigitIsZero(detector))
            isPeriod(character) -> detector.changeState(FoundPeriod(detector))
            isNonZeroDigit(character) -> detector.changeState(IsInteger(detector))
            else -> detector.changeState(InvalidFloat(detector))
        }
    }
}
