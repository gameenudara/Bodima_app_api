package lk.bodima.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BodimaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BodimaApiApplication.class, args);
	}

}
