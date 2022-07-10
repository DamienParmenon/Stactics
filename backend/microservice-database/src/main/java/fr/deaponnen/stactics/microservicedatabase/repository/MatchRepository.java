package fr.deaponnen.stactics.microservicedatabase.repository;

import com.deaponnen.common.entity.MatchEntity;
import com.deaponnen.common.entity.SummonerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MatchRepository extends CrudRepository<MatchEntity, Long> {
    @Query("FROM MatchEntity m JOIN m.metadata md WHERE md.match_id = :id")
    MatchEntity findMatchById(@Param("id") String id);
}
