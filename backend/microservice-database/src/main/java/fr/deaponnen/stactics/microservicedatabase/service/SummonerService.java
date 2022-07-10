package fr.deaponnen.stactics.microservicedatabase.service;

import com.deaponnen.common.dto.SummonerDto;
import com.deaponnen.common.entity.SummonerEntity;
import fr.deaponnen.stactics.microservicedatabase.repository.SummonerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SummonerService {
    @Autowired
    private SummonerRepository summonerRepository;

    public SummonerEntity getSummoner(String name){
        return summonerRepository.findSummonerByName(name);
    }

    public SummonerDto save(SummonerDto summonerDto) {
        if(summonerRepository.findSummonerByName(summonerDto.getName()) == null)
            summonerRepository.save(new SummonerEntity(summonerDto));
        else {
            SummonerEntity entityToUpdate = new SummonerEntity(summonerDto);
            entityToUpdate.setSummoner_id(summonerRepository.findSummonerByName(summonerDto.getName()).getSummoner_id());
            summonerRepository.save(entityToUpdate);
        }
        return summonerDto;
    }
}
