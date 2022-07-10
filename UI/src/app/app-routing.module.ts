import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MatchListComponent } from './component/match-list/match-list.component';
import { SummonerSearchComponent} from './component/summoner-search/summoner-search.component';
import { SummonerInfoComponent} from './component/summoner-info/summoner-info.component';

const routes: Routes = [
  { path: 'search', component: SummonerSearchComponent },
  { path: 'info', component: SummonerInfoComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
