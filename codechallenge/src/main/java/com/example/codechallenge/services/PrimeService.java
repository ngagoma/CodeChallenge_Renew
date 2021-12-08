package com.example.codechallenge.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PrimeService {
	public List<Integer> runPrime(int limit) {
		List<Integer> returnPrimeList = new ArrayList<Integer>();
//		let A be an array of Boolean values
		final boolean[] vals = new boolean[limit];
		for(int i = 2; i < limit; i++) {
			vals[i] = true;
		}	
		
		for(int i=2; i< Math.sqrt(limit); i++) {
			if (vals[i] == true) {
				for (int j = i * i, k = 0; j < limit; k++, j= i * i + (k*i)) {
					vals[j] = false;
				}
			}
		}
		
		for (int t = 0; t < limit; t++) {
			if(vals[t] == true) {
				returnPrimeList.add(t);
			}
		}
		
		return returnPrimeList;
	}
}
