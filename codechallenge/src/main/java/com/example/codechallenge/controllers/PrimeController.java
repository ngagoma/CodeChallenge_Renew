package com.example.codechallenge.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.codechallenge.services.PrimeService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class PrimeController {
	
	PrimeService primeService;
	
	@Autowired
	public PrimeController (PrimeService primeService) {
		this.primeService = primeService;
	}

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot cool!";
	}
	
	@GetMapping("/primes/{limit}")
	public List<Integer> displayPrime(@PathVariable int limit) {
		return primeService.runPrime(limit);
	}	

}
