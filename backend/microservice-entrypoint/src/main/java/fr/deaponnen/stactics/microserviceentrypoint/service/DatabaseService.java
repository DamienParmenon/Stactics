package fr.deaponnen.stactics.microserviceentrypoint.service;

import com.deaponnen.common.dto.MatchDto;
import com.deaponnen.common.dto.SummonerDto;
import fr.deaponnen.stactics.microserviceentrypoint.proxy.MicroserviceDatabaseProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseService {
    @Autowired
    private MicroserviceDatabaseProxy microserviceDatabaseProxy;

    public SummonerDto getSummonerDtoByName(String name){
        return microserviceDatabaseProxy.getSummoner(name);
    }

    public void saveSummoner(SummonerDto summonerDto){
        microserviceDatabaseProxy.saveSummoner(summonerDto);
    }

    public List<MatchDto> getMatchsBySummonerName(String name){
        return microserviceDatabaseProxy.getMatch(name);
    }

    public void saveMatch(MatchDto matchDto, String name){
        microserviceDatabaseProxy.saveMatch(matchDto, name);
    }
}
