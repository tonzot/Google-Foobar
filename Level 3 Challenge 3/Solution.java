import java.math.BigInteger;

public class Solution {
    public static String solution(String x, String y) {
        BigInteger xBig = new BigInteger(x);
        BigInteger yBig = new BigInteger(y);
        BigInteger counter = new BigInteger("0");

        while ( !(xBig.compareTo(new BigInteger("1")) == 0) || !(yBig.compareTo(new BigInteger("1")) == 0)){

            if(xBig.compareTo(new BigInteger("1")) == -1 || yBig.compareTo(new BigInteger("1")) == -1 || xBig.compareTo(yBig) == 0){
                return "impossible";
            }

            if(yBig.compareTo(xBig) == 1){
                BigInteger multiplicant = yBig.divide(xBig);
                if(multiplicant.compareTo(new BigInteger("1")) == 1){
                    multiplicant = multiplicant.subtract(new BigInteger("1"));
                }
                counter = counter.add(multiplicant);
                yBig = yBig.subtract(xBig.multiply(multiplicant));
            } else {
                BigInteger multiplicant = xBig.divide(yBig);
                if(multiplicant.compareTo(new BigInteger("1")) == 1){
                    multiplicant = multiplicant.subtract(new BigInteger("1"));
                }
                counter = counter.add(multiplicant);
                xBig = xBig.subtract(yBig.multiply(multiplicant));
            }

        }

        return counter.toString();

    }
}
