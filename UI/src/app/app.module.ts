import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { MatchListComponent } from './component/match-list/match-list.component';
import { SummonerSearchComponent } from './component/summoner-search/summoner-search.component';
import { SummonerService } from './service/summoner.service';
import { RouterModule } from '@angular/router';
import { MatchComponent } from './component/match/match.component';
import { SummonerInfoComponent } from './component/summoner-info/summoner-info.component';

@NgModule({
  declarations: [
    AppComponent,
    MatchListComponent,
    SummonerSearchComponent,
    MatchComponent,
    SummonerInfoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [SummonerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
