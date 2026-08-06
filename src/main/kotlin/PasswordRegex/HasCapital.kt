class HasCapital(detector: PasswordRegex) : PasswordState(detector) {
    override fun consume(character: String) {
        if (isSpecial(character)) {
            detector.changeState(HasCapitalAndEndsInSpecial(detector))
        } else {
            detector.changeState(HasCapital(detector))
        }
    }
}
