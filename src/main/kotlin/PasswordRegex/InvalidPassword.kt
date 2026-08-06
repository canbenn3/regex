class InvalidPassword(detector: PasswordRegex) : PasswordState(detector) {
    override fun consume(character: String) {
        // Sink state: reserved for the empty-password case; never reached mid-consumption.
    }
}
