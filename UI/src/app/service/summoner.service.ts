import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Summoner } from '../model/summoner';
import { Observable } from 'rxjs';

@Injectable()
export class SummonerService {

  private summonerUrl: string;

  constructor(private http: HttpClient) {
      this.summonerUrl = 'http://localhost:8080/data/summoner';
  }

  public find(name: string): Observable<Summoner>{
    return this.http.get<Summoner>(this.summonerUrl + '/' + name);
  }
}
