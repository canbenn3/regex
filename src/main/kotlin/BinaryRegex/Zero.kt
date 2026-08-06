class Zero(detector: BinaryRegex) : BinaryState(detector) {
    override fun consume(character: String) {
        when (character) {
            "1" -> detector.changeState(One(detector))
            "0" -> detector.changeState(Zero(detector))
            else -> detector.changeState(InvalidBinary(detector))
        }
    }
}
