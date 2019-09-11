package com.rockpaperscissor.game.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// the class for the options rock paper and scissor
public enum Choice {
	ROCK,
	PAPER,
	SCISSOR;
	
	// constants for avoiding object generation on each random call
	private static final List<Choice> VALUES = Collections.unmodifiableList(Arrays.asList(Choice.values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
	
	// return random choice
	public static Choice randomChoice()  {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
}
