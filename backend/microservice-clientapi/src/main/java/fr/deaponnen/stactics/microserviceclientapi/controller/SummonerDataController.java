package fr.deaponnen.stactics.microserviceclientapi.controller;

import com.deaponnen.common.dto.LeagueEntryDto;
import com.deaponnen.common.dto.MatchDto;
import com.deaponnen.common.dto.SummonerDto;
import fr.deaponnen.stactics.microserviceclientapi.service.SummonerDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/data")
public class SummonerDataController {
    @Autowired
    private SummonerDataService summonerDataService;

    @GetMapping("/summoner/{name}")
    public SummonerDto getSummonerDtoByName(@PathVariable String name) throws IOException {
        return this.summonerDataService.getSummonerDtoByName(name);
    }

    @GetMapping("/matchs/{puuid}/ids")
    public List<String> getMatchesIdsBySummonerPuuid(@PathVariable String puuid){
        return this.summonerDataService.getMatchesIdByPuuid(puuid);
    }

    @GetMapping("/summoner/match/{matchId}")
    public MatchDto getMatchDtoById(@PathVariable String matchId) throws IOException {
        return this.summonerDataService.getMatchIdByPuuid(matchId);
    }

    @GetMapping("/summoner/leagueEntry/{summonerId}")
    public LeagueEntryDto getLeagueEntryDtoBySummonerId(@PathVariable String summonerId){
        return this.summonerDataService.getLeagueEntryDtoById(summonerId);
    }

    @GetMapping("/summoner/puuid/{puuid}")
    public SummonerDto getSummonerDtoByPuuid(@PathVariable String puuid){
        return summonerDataService.getSummonerDtoByPuuid(puuid);
    };
}
