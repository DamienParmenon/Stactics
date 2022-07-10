package fr.deaponnen.stactics.microserviceentrypoint.controller;

import fr.deaponnen.stactics.microserviceentrypoint.dto.SummonerDataDto;
import fr.deaponnen.stactics.microserviceentrypoint.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data")
@CrossOrigin(origins = "*")
public class DataController {
    @Autowired
    private DataService dataService;

    @GetMapping("/summoner/{name}")
    public SummonerDataDto getSummonerDataByName(@PathVariable String name){
        return dataService.getDataBySummonerName(name);
    }
}
