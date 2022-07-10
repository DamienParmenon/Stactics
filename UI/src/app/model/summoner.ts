import { Match } from './match';

export class Summoner {
  name!: string;
  profileIconId!: number;
  summonerLevel!: number;
  matchs: Array<Match>;

  constructor(){
    this.matchs = [];
  }
}
