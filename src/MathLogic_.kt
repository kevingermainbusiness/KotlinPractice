import java.io.Serializable
import java.lang.ArithmeticException

/**
 * Rational number converter
 *
 * Let me explain what a rational number is:
 * Let's say for example we have 8 divided by 2 or 8/2
 *
 * A rational number is represented by : P/Q or P divided by Q
 *
 * P being the numerator and Q being the denominator
 *
 * That means 8 is a P and 2 is a Q
 *
 * So first important condition: P and Q should both be integers
 * And also Q must not be equal to 0 or ( Q!=0)
 *
 * @author Kevin Germain
 * */
data class RationalNumber(val numerator: Int, val denominator: Int) : Serializable {
    /**
     * Returns string representation of the [RationalNumber] including its [numerator] and [denominator] values.
     */
    override fun toString(): String = "($numerator, $denominator)"

    /**
     * Returns true if the denominator is not equal to 0
     * */
    inline val isRationalNumber: () -> Boolean get() = { this.denominator != 0 }

    /**
     * Returns the Int result of the sum of the division of the [numerator] by the [denominator]
     * */
    inline val toRationalNumberResult: () -> Int
        get() = {
            if (!isRationalNumber()) throw ArithmeticException("A rational number's denominator cannot be equal to 0")
            numerator / denominator
        }
}
