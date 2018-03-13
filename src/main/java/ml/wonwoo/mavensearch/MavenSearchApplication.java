package ml.wonwoo.mavensearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MavenSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(MavenSearchApplication.class, args);
	}
}
