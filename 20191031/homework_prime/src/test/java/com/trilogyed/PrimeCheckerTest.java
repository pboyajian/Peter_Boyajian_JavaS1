package com.trilogyed;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
public class PrimeCheckerTest {
    private PrimeChecker primeChecker;
    private List<Integer> primes,nonPrimes;
    @Test
    public void shouldReturnTrueForPrimesAndFalseForNonPrimes(){
        primeChecker=new PrimeChecker();
        primes=Arrays.asList(2,5,7,11,13,17,19,23,31);
        nonPrimes=Arrays.asList(-2,5-1,-7,11-1,-13,-17,-19,24,105,729);
        primes.forEach(a->assertTrue(primeChecker.checkPrime(a)));
        nonPrimes.forEach(a->assertFalse(primeChecker.checkPrime(a)));
}
}