import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GameService {

  private baseUrl = 'http://localhost:8080/api/v1/game';

  constructor(private http: HttpClient) { }

  play(player: string) {
    return this.http.post(`${this.baseUrl}`, player);
  }

  getWinner(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
