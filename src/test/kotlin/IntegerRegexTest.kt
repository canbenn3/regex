import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IntegerRegexTest {
    private val detector = IntegerRegex()

    @ParameterizedTest
    @ValueSource(strings = ["1", "123", "3452342352434534524346"])
    fun `recognizes valid integers`(value: String) {
        assertTrue(detector.matches(value))
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "0123", "132a", "0"])
    fun `rejects invalid integers`(value: String) {
        assertFalse(detector.matches(value))
    }

    @Test
    fun `each call to matches is independent`() {
        assertTrue(detector.matches("123"))
        assertFalse(detector.matches("0123"))
        assertTrue(detector.matches("9"))
    }
}
