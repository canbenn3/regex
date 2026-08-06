class InvalidFloat(detector: FloatRegex) : FloatState(detector) {
    override fun consume(character: String) {
        // Sink state: once invalid, no character can make the float valid again.
    }
}
