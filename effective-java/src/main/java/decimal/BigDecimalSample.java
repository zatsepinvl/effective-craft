package decimal;

import java.math.BigDecimal;

public class BigDecimalSample {
    public static void main(String[] args) {
        double d = 1.2d;
        BigDecimal decimal1 = new BigDecimal(d);
        BigDecimal decimal2 = BigDecimal.valueOf(d);
        System.out.println(decimal1);
        System.out.println(decimal2);
        System.out.println(decimal1.equals(decimal2));
    }
}
