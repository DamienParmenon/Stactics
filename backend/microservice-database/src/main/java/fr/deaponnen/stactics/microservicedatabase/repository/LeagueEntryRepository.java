package fr.deaponnen.stactics.microservicedatabase.repository;

import com.deaponnen.common.entity.LeagueEntryEntity;
import org.springframework.data.repository.CrudRepository;

public interface LeagueEntryRepository extends CrudRepository<LeagueEntryEntity, Long> {
}
