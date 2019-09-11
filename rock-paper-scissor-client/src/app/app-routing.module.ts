import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PlayGameComponent } from './play-game/play-game.component';
import { GameOptionsComponent } from './game-options/game-options.component';


const routes: Routes = [
  { path: '', redirectTo: 'play', pathMatch: 'full'},
  { path: 'play', component: PlayGameComponent },
  { path: 'options', component: GameOptionsComponent },
  { path: '**', redirectTo: 'play', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
