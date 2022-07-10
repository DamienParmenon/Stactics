import { Component, OnInit, Input } from '@angular/core';
import { Summoner } from '../../model/summoner';
import { Match } from '../../model/match';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-match-list',
  templateUrl: './match-list.component.html',
  styleUrls: ['./match-list.component.css']
})
export class MatchListComponent {

  @Input() matchs!: Array<Match>;

  constructor(){  }
}
