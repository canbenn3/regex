class ValidUsernameDomain(detector: EmailRegex) : EmailState(detector) {
    override fun consume(character: String) {
        when {
            isPeriod(character) -> detector.changeState(TransitionToEmail(detector))
            isForbiddenInDomainOrHost(character) -> detector.changeState(InvalidEmail(detector))
            else -> detector.changeState(ValidUsernameDomain(detector))
        }
    }
}
