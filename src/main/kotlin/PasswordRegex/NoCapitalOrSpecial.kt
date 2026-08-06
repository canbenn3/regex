class NoCapitalOrSpecial(detector: PasswordRegex) : PasswordState(detector) {
    override fun consume(character: String) {
        when {
            isCapital(character) -> detector.changeState(HasCapital(detector))
            isSpecial(character) -> detector.changeState(HasSpecial(detector))
            else -> detector.changeState(NoCapitalOrSpecial(detector))
        }
    }
}
