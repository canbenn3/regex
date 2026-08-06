class InvalidBinary(detector: BinaryRegex) : BinaryState(detector) {
    override fun consume(character: String) {
        // Sink state: once invalid, no character can make the binary number valid again.
    }
}
