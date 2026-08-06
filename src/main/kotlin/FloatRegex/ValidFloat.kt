class ValidFloat(detector: FloatRegex) : FloatState(detector) {
    override fun consume(character: String) {
        if (isDigit(character)) {
            detector.changeState(ValidFloat(detector))
        } else {
            detector.changeState(InvalidFloat(detector))
        }
    }
}
