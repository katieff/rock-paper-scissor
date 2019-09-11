package com.rockpaperscissor.game.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rockpaperscissor.game.model.Game;
import com.rockpaperscissor.game.service.GameService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class GameController {
	@Autowired
	private GameService gameService;
	
	@GetMapping("/game")
	public Game getGameOptions() {
		return gameService.getGameOptions();
	}
	
	@PostMapping("/game")
	public void playGame(@Valid @RequestBody String playerChoice) {
		gameService.playGame(playerChoice);
	}
	

}
