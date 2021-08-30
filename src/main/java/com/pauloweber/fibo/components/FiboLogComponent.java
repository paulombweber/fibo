package com.pauloweber.fibo.components;

import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class FiboLogComponent {

    public BigInteger getFibo(int number) {
        if(number < 1) return BigInteger.ZERO;
        return innerGetFibo(number)[1];
    }

    private BigInteger[] innerGetFibo(int number) {
        if(number == 1) {
            return new BigInteger[] {BigInteger.ZERO,BigInteger.ONE};
        }
        int m = number/2;

        BigInteger[] temp = innerGetFibo(m);

        BigInteger previous = temp[0];
        BigInteger current = temp[1];

        BigInteger prev = (previous.multiply(previous)).add(current.multiply(current));
        BigInteger cur = current.multiply(previous.multiply(BigInteger.TWO).add(current));

        if(number % 2 == 0) {
            return new BigInteger[] {prev, cur};
        }
        else {
            return new BigInteger[] {cur, prev.add(cur)};
        }
    }
}
