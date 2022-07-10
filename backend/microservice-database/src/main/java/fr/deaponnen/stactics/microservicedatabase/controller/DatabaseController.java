package fr.deaponnen.stactics.microservicedatabase.controller;

import com.deaponnen.common.dto.MatchDto;
import com.deaponnen.common.dto.SummonerDto;
import com.deaponnen.common.entity.SummonerEntity;
import fr.deaponnen.stactics.microservicedatabase.service.LeagueEntryService;
import fr.deaponnen.stactics.microservicedatabase.service.MatchService;
import fr.deaponnen.stactics.microservicedatabase.service.SummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/database")
public class DatabaseController {
    @Autowired
    private SummonerService summonerService;

    @Autowired
    private MatchService matchService;

    @Autowired
    private LeagueEntryService leagueEntryService;

    @GetMapping("/summoner/{name}")
    public SummonerDto getSummoner(@PathVariable String name){
        return new SummonerDto(summonerService.getSummoner(name));
    }

    @GetMapping("/matchs/{name}")
    public List<MatchDto> getMatch(@PathVariable String name){
        SummonerEntity toReturn = summonerService.getSummoner(name);
        if(toReturn != null)
            return toReturn.getMatchs().stream().map(MatchDto::new).collect(Collectors.toList());
        else
            return new ArrayList<>();
    }

    @PostMapping("/summoner/save")
    public SummonerDto saveSummoner(@RequestBody SummonerDto summonerDto){
        return summonerService.save(summonerDto);
    }

    @PostMapping("/match/save/{name}")
    public void saveMatch(@RequestBody MatchDto matchDto, @PathVariable String name){
        matchService.save(matchDto, name);
    }
}
