class LookingForFirstEmailChar(detector: EmailRegex) : EmailState(detector) {
    override fun consume(character: String) {
        if (isForbiddenInUsername(character)) {
            detector.changeState(InvalidEmail(detector))
        } else {
            detector.changeState(ValidUsername(detector))
        }
    }
}
