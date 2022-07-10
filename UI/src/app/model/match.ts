import { Participant } from './participant'

export class Match {
  position!: number;
  playersEliminated!: number;
  lastRound!: number;
  participants!: Array<Participant>;
}
