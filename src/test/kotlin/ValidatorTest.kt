//import assertk.assert
//import assertk.assertions.isEqualTo
//import com.cqrsexample.domain.validator.Invalid
//import com.cqrsexample.domain.validator.Valid
//import com.cqrsexample.domain.validator.Validated
//import org.junit.Test
//
//
//internal class ValidatorTest {
//
//
//    fun isOdd(x: Int): Validated<String, Int> = if (x % 2 == 1) Valid(x) else Invalid("even")
//
//
//    @Test
//    fun validResult() {
//
//        assert(isOdd(3)).isEqualTo(Valid(3))
//        assert(isOdd(4)).isEqualTo(Invalid("even"))
//
//    }
//}