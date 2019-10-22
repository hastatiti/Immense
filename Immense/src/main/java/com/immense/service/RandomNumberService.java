package com.immense.service;

import java.util.Random;

import org.springframework.stereotype.Service;

//Service for our controllers
@Service
public class RandomNumberService {

	//Number generator
	public int getRandomNumber() {
		Random rand = new Random(); 
		int value = rand.nextInt(9000000) + 1000000 -1; 
		return value;
	}
}
