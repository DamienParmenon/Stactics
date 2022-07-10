package fr.deaponnen.stactics.microserviceentrypoint.service;

import com.deaponnen.common.dto.SummonerDto;
import fr.deaponnen.stactics.microserviceentrypoint.proxy.MicroserviceClientApiProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiotApiService {
    @Autowired
    private MicroserviceClientApiProxy microserviceClientApiProxy;

    public SummonerDto getSummonerDtoByName(String name){
        return microserviceClientApiProxy.getSummonerDtoByName(name);
    }
}
