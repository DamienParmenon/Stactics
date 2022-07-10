package fr.deaponnen.stactics.microservicedatabase.repository;

import com.deaponnen.common.entity.SummonerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SummonerRepository extends CrudRepository<SummonerEntity, Long> {
    @Query("FROM SummonerEntity s WHERE s.name = :name")
    SummonerEntity findSummonerByName(@Param("name") String name);
}
