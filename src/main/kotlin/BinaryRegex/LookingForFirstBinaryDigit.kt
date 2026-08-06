class LookingForFirstBinaryDigit(detector: BinaryRegex) : BinaryState(detector) {
    override fun consume(character: String) {
        if (character == "1") {
            detector.changeState(One(detector))
        } else {
            detector.changeState(InvalidBinary(detector))
        }
    }
}
