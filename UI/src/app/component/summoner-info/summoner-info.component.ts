import { Component, OnInit } from '@angular/core';
import { Summoner } from '../../model/summoner';
import { SummonerService } from '../../service/summoner.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-summoner-info',
  templateUrl: './summoner-info.component.html',
  styleUrls: ['./summoner-info.component.css']
})

export class SummonerInfoComponent implements OnInit {

  summoner!: Summoner;
  profileIconUrl!: string;

  constructor(private summonerService: SummonerService, private route: ActivatedRoute) {
    this.summoner = new Summoner();
  }

  ngOnInit(): void {
    this.summonerService.find(this.route.snapshot.params['name']).subscribe(data => {
      this.summoner = data;
      this.profileIconUrl = "/assets/img/profileicon/" + data.profileIconId + ".png";
    });
  }

}
