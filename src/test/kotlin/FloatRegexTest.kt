import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class FloatRegexTest {
    private val detector = FloatRegex()

    @ParameterizedTest
    @ValueSource(
        strings = ["1.0", "123.34", "0.20000", "12349871234.12340981234098", ".123"]
    )
    fun `recognizes valid floats`(value: String) {
        assertTrue(detector.matches(value))
    }

    @ParameterizedTest
    @ValueSource(strings = ["123", "123.123.", "123.02a", "123.", "012.4", "", "."])
    fun `rejects invalid floats`(value: String) {
        assertFalse(detector.matches(value))
    }

    @Test
    fun `each call to matches is independent`() {
        assertTrue(detector.matches("1.5"))
        assertFalse(detector.matches("123"))
        assertTrue(detector.matches("0.1"))
    }
}
