package com.example.codechallenge.services;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PrimeServiceTest {
	
	@Autowired
	private PrimeService primeService;
	
	@Test
	void runPrime() {
//		Test 1: let's enter 29 as a number
		List<Integer> returnPrimeList1 = primeService.runPrime(29);
		List<Integer> result1 = Arrays.asList(2,3,5,7,11,13,17,19,23);
		Assertions.assertEquals(result1, returnPrimeList1);
		
//		Test 2: let's enter 33 as a number
		List<Integer> returnPrimeList2 = primeService.runPrime(33);
		List<Integer> result2 = Arrays.asList(2,3,5,7,11,13,17,19,23,29,31,32);
		Assertions.assertNotEquals(result2, returnPrimeList2);
		
	}
	
}