package com.rockpaperscissor.game.service;

import org.springframework.stereotype.Service;

import com.rockpaperscissor.game.model.Game;

// The service class
@Service
public class GameService {
	
	private Game game;
	
	// init new game and find the winner
	public void playGame(String playerChoice) {
		this.game = new Game(playerChoice);
		this.game.play();
	}
	
	// return the game options
	public Game getGameOptions() {
		return this.game;
	}

}
