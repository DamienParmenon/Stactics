package fr.deaponnen.stactics.microserviceclientapi.service;

import com.deaponnen.common.dto.LeagueEntryDto;
import com.deaponnen.common.dto.MatchDto;
import com.deaponnen.common.dto.SummonerDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.*;


@Service
public class SummonerDataService {
    private final String riotToken = "RGAPI-98c63664-8925-443f-a016-c32fd0e38212";
    private final WebClient webclient;

    public SummonerDataService(){
        this.webclient = WebClient.create();
    }


    public LeagueEntryDto getLeagueEntryDtoById(String id){
        return this.sendRequest("https://euw1.api.riotgames.com/tft/league/v1/entries/by-summoner/"
                + id, new TypeReference<List<LeagueEntryDto>>(){}).get(0);
    }

    public SummonerDto getSummonerDtoByPuuid(String puuid){
        return this.sendRequest("https://euw1.api.riotgames.com/tft/summoner/v1/summoners/by-puuid/"
                + puuid, SummonerDto.class);
    }

    public SummonerDto getSummonerDtoByName(String name){
        return this.sendRequest("https://euw1.api.riotgames.com/tft/summoner/v1/summoners/by-name/"
                + name, SummonerDto.class);
    }

    public List<String> getMatchesIdByPuuid(String puuid){
        return this.sendRequest("https://europe.api.riotgames.com/tft/match/v1/matches/by-puuid/"
                + puuid + "/ids?start=0&count=2", List.class);
    }

    public MatchDto getMatchIdByPuuid(String matchId) {
        MatchDto temp = this.sendRequest("https://europe.api.riotgames.com/tft/match/v1/matches/" + matchId, MatchDto.class);
        if(temp.getInfo().getQueue_id() == 1100) return temp;
        return null;
    }

    private List<MatchDto> getMatchesByMatchesId(List<String> idMatchs){
        List<MatchDto> matches = new ArrayList<>();
        for(String id : idMatchs){
            MatchDto temp = this.sendRequest("https://europe.api.riotgames.com/tft/match/v1/matches/" + id, MatchDto.class);
            if(temp.getInfo().getQueue_id() == 1100) matches.add(temp);
        }
        return matches;
    }

    public <T> T sendRequest(String uri, Class<T> valueType) {
        ObjectMapper objectMapper = new ObjectMapper();
        Optional<String> result = getRequestResponse(uri);
        if(result.isPresent()) {
            try {
                return objectMapper.readValue(result.get(), valueType);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public <T> T sendRequest(String uri, TypeReference<T> typeReference) {
        ObjectMapper objectMapper = new ObjectMapper();
        Optional<String> result = getRequestResponse(uri);
        if(result.isPresent()) {
            try {
                return objectMapper.readValue(result.get(), typeReference);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public Optional<String> getRequestResponse(String uri){
        return this.webclient
                .get()
                .uri(uri)
                .header("User-Agent" , "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.0.0 Safari/537.36")
                .header("Accept-Language", "en-US,en;q=0.9,fr-FR;q=0.8,fr;q=0.7")
                .header("Accept-Charset", "application/x-www-form-urlencoded; charset=UTF-8")
                .header("Origin", "https://developer.riotgames.com")
                .header("X-Riot-Token", this.riotToken)
                .retrieve()
                .bodyToMono(String.class)
                .blockOptional();
    }
}
