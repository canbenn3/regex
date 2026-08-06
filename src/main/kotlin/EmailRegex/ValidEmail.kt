class ValidEmail(detector: EmailRegex) : EmailState(detector) {
    override fun consume(character: String) {
        if (isForbiddenInDomainOrHost(character)) {
            detector.changeState(InvalidEmail(detector))
        } else {
            detector.changeState(ValidEmail(detector))
        }
    }
}
