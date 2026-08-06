class InvalidInteger(detector: IntegerRegex) : IntegerState(detector) {
    override fun consume(character: String) {
        // Sink state: once invalid, no character can make the integer valid again.
    }
}
