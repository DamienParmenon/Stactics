package fr.deaponnen.stactics.microservicedatabase.service;

import com.deaponnen.common.dto.MatchDto;
import com.deaponnen.common.entity.MatchEntity;
import com.deaponnen.common.entity.SummonerEntity;
import fr.deaponnen.stactics.microservicedatabase.repository.MatchRepository;
import fr.deaponnen.stactics.microservicedatabase.repository.SummonerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private SummonerRepository summonerRepository;

    public void save(MatchDto matchDto, String summonerName) {
        SummonerEntity toUpdate = summonerRepository.findSummonerByName(summonerName);
        if(!toUpdate.getMatchs()
                .stream()
                .map(m -> m.getMetadata().getMatch_id())
                .collect(Collectors.toList())
                .contains(matchDto.getMetadata().getMatch_id()))
            toUpdate.addMatch(new MatchEntity(matchDto));
        summonerRepository.save(toUpdate);
    }
}
