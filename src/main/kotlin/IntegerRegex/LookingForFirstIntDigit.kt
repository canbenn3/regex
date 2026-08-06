class LookingForFirstIntDigit(detector: IntegerRegex) : IntegerState(detector) {
    override fun consume(character: String) {
        if (isNonZeroDigit(character)) {
            detector.changeState(ValidInteger(detector))
        } else {
            detector.changeState(InvalidInteger(detector))
        }
    }
}
