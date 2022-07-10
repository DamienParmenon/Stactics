package fr.deaponnen.stactics.microserviceentrypoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("fr.deaponnen.stactics.microserviceentrypoint")
public class MicroserviceEntrypointApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceEntrypointApplication.class, args);
	}

}