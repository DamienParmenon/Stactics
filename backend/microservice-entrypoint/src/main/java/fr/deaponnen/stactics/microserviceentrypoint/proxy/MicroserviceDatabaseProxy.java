package fr.deaponnen.stactics.microserviceentrypoint.proxy;

import com.deaponnen.common.dto.MatchDto;
import com.deaponnen.common.dto.SummonerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@FeignClient(name = "microservice-database", url = "localhost:8082")
public interface MicroserviceDatabaseProxy {
    @GetMapping(value = "/database/summoner/{name}")
    SummonerDto getSummoner(@PathVariable String name);

    @GetMapping(value = "/database/matchs/{name}")
    List<MatchDto> getMatch(@PathVariable String name);

    @PostMapping(value = "/database/summoner/save")
    SummonerDto saveSummoner(@RequestBody SummonerDto summonerDto);

    @PostMapping(value = "/database/match/save/{name}")
    MatchDto saveMatch(@RequestBody MatchDto matchDto, @PathVariable String name);
}
