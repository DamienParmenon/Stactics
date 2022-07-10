package fr.deaponnen.stactics.microserviceentrypoint.proxy;

import com.deaponnen.common.dto.LeagueEntryDto;
import com.deaponnen.common.dto.MatchDto;
import com.deaponnen.common.dto.SummonerDto;
import fr.deaponnen.stactics.microserviceentrypoint.dto.SummonerDataDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.List;

@FeignClient(name = "microservice-clientapi", url = "localhost:8081")
public interface MicroserviceClientApiProxy {
    @GetMapping(value = "/data/summoner/{name}")
    public SummonerDto getSummonerDtoByName(@PathVariable String name);

    @GetMapping(value = "/data/matchs/{puuid}/ids")
    public List<String> getMatchesIdsBySummonerPuuid(@PathVariable String puuid);

    @GetMapping(value = "/data/summoner/match/{matchId}")
    public MatchDto getMatchDtoById(@PathVariable String matchId);

    @GetMapping(value = "/data/summoner/leagueEntry/{summonerId}")
    public LeagueEntryDto getLeagueEntryDtoBySummonerId(@PathVariable String summonerId);

    @GetMapping(value = "/data/summoner/puuid/{puuid}")
    public SummonerDto getSummonerDtoByPuuid(@PathVariable String puuid);
}
