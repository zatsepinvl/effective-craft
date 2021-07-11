package decimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;

public class BigDecimalPlaygroundTests {
    @Test
    public void serialization_deserialization() {
        BigDecimal decimal = new BigDecimal("1.11");
        BigDecimal decimal1 = new BigDecimal(decimal.toString());
        Assertions.assertEquals(decimal, decimal1);
    }


    @Test
    public void multiplication() {
        long a = 231231232222L;
        long b = 1312312232321111L;
        BigDecimal rangeRate = new BigDecimal("0." + a);
        BigDecimal baseAmount = new BigDecimal("0." + b);
        BigDecimal rangeFees = rangeRate.multiply(baseAmount, new MathContext(15));
        System.out.println(rangeFees);
        System.out.println("0.0" + BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(b)));
    }
}
