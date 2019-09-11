package com.rockpaperscissor.game.model;

public class Game {
	
	private Choice pc;
	private Choice player;
	private String winner;
	
	public static final String WINNER_PLAYER = "you";
	public static final String WINNER_PC = "the computer";
	
	public Game(String playerChoice) {
		this.player = Choice.valueOf(playerChoice);
		this.pc = Choice.randomChoice();
		this.winner = "";
	}
	
	// getters, no setters needed
	public Choice getPlayer() {
		return player;
	}

	public Choice getPc() {
		return pc;
	}

	public String getWinner() {
		return winner;
	}
	
	// validate if Choice a beats Choice b
	private boolean beat(Choice a, Choice b) {
		if(a.equals(Choice.ROCK) && b.equals(Choice.SCISSOR) 
				|| (a.equals(Choice.PAPER) && b.equals(Choice.ROCK))
				|| (a.equals(Choice.SCISSOR) && b.equals(Choice.PAPER))) {
			return true;
		}
		return false;
	}
	
	// find the winner
	public void play() {
		if(this.player.equals(this.pc)) {
			this.winner = "noone";
		} else if (beat(this.pc,this.player)) {
			this.winner = WINNER_PC;
		} else {
			this.winner = WINNER_PLAYER;
		}
	}
}
