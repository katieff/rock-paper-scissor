package com.rockpaperscissor.game.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.rockpaperscissor.game.model.Choice;
import com.rockpaperscissor.game.model.Game;

class GameTest {
	
	private final Game game = new Game("ROCK");

	@Test
	void testPlay() {
		game.play();
		Choice pcChoice = game.getPc();
		switch(pcChoice) {
		case ROCK :
			assertEquals("noone",game.getWinner());
			break;
		case SCISSOR :
			assertEquals(Game.WINNER_PLAYER, game.getWinner());
			break;
		case PAPER :
			assertEquals(Game.WINNER_PC, game.getWinner());
			break;
		}
	}
}
