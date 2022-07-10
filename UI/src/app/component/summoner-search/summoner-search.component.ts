import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SummonerService } from '../../service/summoner.service';

@Component({
  selector: 'app-summoner-search',
  templateUrl: './summoner-search.component.html',
  styleUrls: ['./summoner-search.component.css']
})
export class SummonerSearchComponent {

  summonerName!: string;

  constructor(private route: ActivatedRoute,
                    private router: Router,
                      private summonerService: SummonerService) { }

  onSubmit(){
    this.gotoSummonerMatchs();
  }

  gotoSummonerMatchs() {
      this.router.navigate(['/info', { name: this.summonerName }]);
  }
}
