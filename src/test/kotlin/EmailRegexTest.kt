import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class EmailRegexTest {
    private val detector = EmailRegex()

    @ParameterizedTest
    @ValueSource(
        strings = ["a@b.c", "joseph.ditton@usu.edu", "{}*\$.&\$*(@*\$%&.*&*"]
    )
    fun `recognizes valid email addresses`(value: String) {
        assertTrue(detector.matches(value))
    }

    @ParameterizedTest
    @ValueSource(
        strings = ["@b.c", "a@b@c.com", "a.b@b.b.c", "joseph ditton@usu.edu", "", "a@b", "a@bc"]
    )
    fun `rejects invalid email addresses`(value: String) {
        assertFalse(detector.matches(value))
    }

    @Test
    fun `each call to matches is independent`() {
        assertTrue(detector.matches("a@b.c"))
        assertFalse(detector.matches("@b.c"))
        assertTrue(detector.matches("x@y.z"))
    }
}
