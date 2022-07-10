package fr.deaponnen.stactics.microservicedatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.deaponnen.common.entity")
@EnableJpaRepositories("fr.deaponnen.stactics.microservicedatabase.repository")
public class MicroserviceDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceDatabaseApplication.class, args);
	}

}
