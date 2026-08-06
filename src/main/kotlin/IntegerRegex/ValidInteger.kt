class ValidInteger(detector: IntegerRegex) : IntegerState(detector) {
    override fun consume(character: String) {
        if (isDigit(character)) {
            detector.changeState(ValidInteger(detector))
        } else {
            detector.changeState(InvalidInteger(detector))
        }
    }
}
