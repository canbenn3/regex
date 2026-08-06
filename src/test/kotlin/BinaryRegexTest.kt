import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BinaryRegexTest {
    private val detector = BinaryRegex()

    @ParameterizedTest
    @ValueSource(strings = ["1", "11", "101", "111111", "10011010001"])
    fun `recognizes valid binary numbers`(value: String) {
        assertTrue(detector.matches(value))
    }

    @ParameterizedTest
    @ValueSource(strings = ["01", "10", "1000010", "100a01", ""])
    fun `rejects invalid binary numbers`(value: String) {
        assertFalse(detector.matches(value))
    }

    @Test
    fun `each call to matches is independent`() {
        assertTrue(detector.matches("101"))
        assertFalse(detector.matches("10"))
        assertTrue(detector.matches("1"))
    }
}
