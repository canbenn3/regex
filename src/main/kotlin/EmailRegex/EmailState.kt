abstract class EmailState(protected val detector: EmailRegex) : State {
    companion object {
        private const val FORBIDDEN_USERNAME_CHARACTERS = "@ "
        private const val FORBIDDEN_DOMAIN_OR_HOST_CHARACTERS = "@ ."

        fun isForbiddenInUsername(character: String): Boolean = character in FORBIDDEN_USERNAME_CHARACTERS

        fun isForbiddenInDomainOrHost(character: String): Boolean = character in FORBIDDEN_DOMAIN_OR_HOST_CHARACTERS

        fun isPeriod(character: String): Boolean = character == "."
    }
}
