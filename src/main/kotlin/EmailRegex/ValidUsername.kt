class ValidUsername(detector: EmailRegex) : EmailState(detector) {
    override fun consume(character: String) {
        when {
            character == "@" -> detector.changeState(TransitionToDomain(detector))
            isForbiddenInUsername(character) -> detector.changeState(InvalidEmail(detector))
            else -> detector.changeState(ValidUsername(detector))
        }
    }
}
