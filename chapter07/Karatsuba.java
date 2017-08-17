import java.math.BigInteger;

public class Karatsuba {

  public BigInteger multiply(BigInteger x, BigInteger y) {

    int n = Math.max(x.bitLength(), y.bitLength());
    if (n <= 3) return x.multiply(y);
    n = (n/2) + (n%2);

    BigInteger a1 = x.shiftRight(n);
    BigInteger a0 = x.subtract(a1.shiftLeft(n));
    BigInteger b1 = y.shiftRight(n);
    BigInteger b0 = y.subtract(b1.shiftLeft(n));

    BigInteger z0 = a0.multiply(b0);
    BigInteger z1 = a1.multiply(b1);
    BigInteger z2 = (a0.add(a1)).multiply((b0.add(b1))).subtract(z0).subtract(z1);

    return z0.add(z1.shiftLeft(n*2)).add(z2.shiftLeft(n));
  }

}
