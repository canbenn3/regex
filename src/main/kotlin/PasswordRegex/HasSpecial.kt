class HasSpecial(detector: PasswordRegex) : PasswordState(detector) {
    override fun consume(character: String) {
        if (isCapital(character)) {
            detector.changeState(ValidPassword(detector))
        } else {
            detector.changeState(HasSpecial(detector))
        }
    }
}
