package com.deaponnen.statft_db.repository;

import com.deaponnen.common.entity.MatchEntity;
import com.deaponnen.common.entity.SummonerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MatchRepository extends CrudRepository<MatchEntity, Long> {
    @Query("FROM MatchEntity m WHERE m.summoner = :summoner")
    List<MatchEntity> getAllMatchsBySummoner(@Param("summoner") SummonerEntity summoner);
}
