class InvalidEmail(detector: EmailRegex) : EmailState(detector) {
    override fun consume(character: String) {
        // Sink state: once invalid, no character can make the email valid again.
    }
}
