package fr.deaponnen.stactics.microserviceentrypoint.service;

import com.deaponnen.common.dto.LeagueEntryDto;
import com.deaponnen.common.dto.MatchDto;
import com.deaponnen.common.dto.ParticipantDto;
import com.deaponnen.common.dto.SummonerDto;
import fr.deaponnen.stactics.microserviceentrypoint.dto.MatchDataDto;
import fr.deaponnen.stactics.microserviceentrypoint.dto.ParticipantDataDto;
import fr.deaponnen.stactics.microserviceentrypoint.dto.SummonerDataDto;
import fr.deaponnen.stactics.microserviceentrypoint.proxy.MicroserviceClientApiProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataService {
    @Autowired
    private DatabaseService databaseService;

    @Autowired
    private RiotApiService riotApiService;

    @Autowired
    private MicroserviceClientApiProxy microserviceClientApiProxy;

    public SummonerDataDto getDataBySummonerName(String name) {
        SummonerDto summoner = microserviceClientApiProxy.getSummonerDtoByName(name);
        databaseService.saveSummoner(summoner);
        List<String> matchesId = microserviceClientApiProxy.getMatchesIdsBySummonerPuuid(summoner.getPuuid());
        List<MatchDto> listDatabaseMatchs = databaseService.getMatchsBySummonerName(name);
        listDatabaseMatchs.sort(Comparator.comparingLong(o -> o.getInfo().getGame_datetime()));
        List <MatchDto> listMatchs = new ArrayList<>(listDatabaseMatchs);
        for(String matchId : matchesId){
            MatchDto temp = microserviceClientApiProxy.getMatchDtoById(matchId);
            if(this.isAlreadyHere(temp, listMatchs)) break;
            listMatchs.add(temp);
        }
        for(MatchDto match : listMatchs)
            databaseService.saveMatch(match, summoner.getName());
        return this.extractUsefullData(summoner, listMatchs);
    }

    public boolean isAlreadyHere(MatchDto match, List<MatchDto> matchs){
        return matchs.stream()
                .map(m -> m.getMetadata().getMatch_id())
                .collect(Collectors.toList())
                .contains(match.getMetadata().getMatch_id());
    }

    private SummonerDataDto extractUsefullData(SummonerDto summoner, List<MatchDto> listMatchs) {
        SummonerDataDto summonerToReturn = new SummonerDataDto();
        LeagueEntryDto summonerLeagueEntry = microserviceClientApiProxy.getLeagueEntryDtoBySummonerId(summoner.getId());
        summonerToReturn.setName(summoner.getName());
        summonerToReturn.setProfileIconId(summoner.getProfileIconId());
        summonerToReturn.setSummonerLevel(summoner.getSummonerLevel());
        summonerToReturn.setRank(summonerLeagueEntry.getRank());
        summonerToReturn.setTier(summonerLeagueEntry.getTier());
        summonerToReturn.setMatchs(this.extractUsefullMatchesData(listMatchs, summoner.getPuuid()));
        return summonerToReturn;
    }

    private List<MatchDataDto> extractUsefullMatchesData(List<MatchDto> listMatchs, String puuid) {
        List<MatchDataDto> matchesToReturn = new ArrayList<>();
        for(MatchDto match : listMatchs){
            MatchDataDto matchResult = new MatchDataDto();
            matchResult.setPosition(match.getInfo().getParticipants().stream()
                    .filter(p -> p.getPuuid().equals(puuid)).findAny().get().getPlacement());
            matchResult.setLastRound(match.getInfo().getParticipants().stream()
                    .filter(p -> p.getPuuid().equals(puuid)).findAny().get().getLast_round());
            matchResult.setPlayersEliminated(match.getInfo().getParticipants().stream()
                    .filter(p -> p.getPuuid().equals(puuid)).findAny().get().getPlayers_eliminated());
            matchResult.setParticipants(this.getParticipantsData(match));
            matchesToReturn.add(matchResult);
        }
        return matchesToReturn;
    }

    private List<ParticipantDataDto> getParticipantsData(MatchDto match){
        List<ParticipantDataDto> participants = new ArrayList<>();
        for(ParticipantDto participant : match.getInfo().getParticipants()) {
            ParticipantDataDto participantToAdd = new ParticipantDataDto();
            LeagueEntryDto leagueEntry = microserviceClientApiProxy
                    .getLeagueEntryDtoBySummonerId(microserviceClientApiProxy.getSummonerDtoByPuuid(participant.getPuuid()).getId());
            participantToAdd.setName(leagueEntry.getSummonerName());
            participantToAdd.setPosition(participant.getPlacement());
            participantToAdd.setRank(leagueEntry.getRank());
            participantToAdd.setTier(leagueEntry.getTier());
            participants.add(participantToAdd);
        }
        participants.sort(Comparator.comparingInt(ParticipantDataDto::getPosition));
        return participants;
    }
}
