import { Component, OnInit } from '@angular/core';
import { Choice } from '../choice';
import { GameService } from '../game.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-play-game',
  templateUrl: './play-game.component.html',
  styleUrls: ['./play-game.component.css']
})
export class PlayGameComponent implements OnInit {
  player: string;
  choices : string[] = Object.keys(Choice);


  constructor(private gameService: GameService,
    private router: Router) {}

  ngOnInit() {
    this.choices = this.choices.slice(this.choices.length / 2);
  }

  playGame() {
    this.gameService.play(this.player).subscribe(data => {
      this.router.navigate(['options']);
    }, error => console.log(error));
    
  }

  playGameClick(mychoice: string) {
    this.gameService.play(mychoice).subscribe(data => {
      this.router.navigate(['options']);
    }, error => console.log(error));
    
  }

  parseValue(value : string) {
    this.player = value;
  }

}
