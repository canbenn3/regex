class TransitionToDomain(detector: EmailRegex) : EmailState(detector) {
    override fun consume(character: String) {
        if (isForbiddenInDomainOrHost(character)) {
            detector.changeState(InvalidEmail(detector))
        } else {
            detector.changeState(ValidUsernameDomain(detector))
        }
    }
}
