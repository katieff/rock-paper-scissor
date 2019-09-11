import { Component, OnInit } from '@angular/core';
import { Game } from '../game';
import { GameService } from '../game.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-game-options',
  templateUrl: './game-options.component.html',
  styleUrls: ['./game-options.component.css']
})
export class GameOptionsComponent implements OnInit {
  myGame: Game;

  constructor(private gameService: GameService,
    private router: Router) { }

  ngOnInit() {
    this.myGame = new Game();

    this.gameService.getWinner()
    .subscribe(data => {
      this.myGame = data;
    }, error => console.log(error));
  }

  playAgain() {
    this.router.navigate(['play']);
  }

}
