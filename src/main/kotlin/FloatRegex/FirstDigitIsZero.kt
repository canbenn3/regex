class FirstDigitIsZero(detector: FloatRegex) : FloatState(detector) {
    override fun consume(character: String) {
        if (isPeriod(character)) {
            detector.changeState(FoundPeriod(detector))
        } else {
            detector.changeState(InvalidFloat(detector))
        }
    }
}
