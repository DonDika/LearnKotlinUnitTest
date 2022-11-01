import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CalculatorTest{

    private val calculator = Calculator()

    @Test
    fun testAddSuccess(){
        val result = calculator.add(10, 10)
        assertEquals(20, result, "The result must be 20")

    }

    @Test
    fun testAddSuccess2(){
        val result = calculator.add(20, 10)
        assertEquals(30, result, "The result must be 30")
        //(expected, actual, message)
    }

    @Test
    fun testDivideSuccess(){
        val result = calculator.divide(100, 10)
        assertEquals(10, result)
    }

    @Test
    fun testDivideFailed(){
        assertThrows<IllegalArgumentException>{
            calculator.divide(100, 0)
        }
    }





}