import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PasswordRegexTest {
    private val detector = PasswordRegex()

    @ParameterizedTest
    @ValueSource(
        strings = [
            "aaaaH!aa",
            "1234567*9J",
            "asdpoihj;loikjasdf;ijp;lij2309jasd;lfkm20ij@aH"
        ]
    )
    fun `recognizes valid passwords`(value: String) {
        assertTrue(detector.matches(value))
    }

    @ParameterizedTest
    @ValueSource(
        strings = ["a", "aaaaaaa!", "aaaHaaaaa", "Abbbbbbb!", ""]
    )
    fun `rejects invalid passwords`(value: String) {
        assertFalse(detector.matches(value))
    }

    @Test
    fun `each call to matches is independent`() {
        assertTrue(detector.matches("aaaaH!aa"))
        assertFalse(detector.matches("aaaHaaaaa"))
        assertTrue(detector.matches("1234567*9J"))
    }
}
