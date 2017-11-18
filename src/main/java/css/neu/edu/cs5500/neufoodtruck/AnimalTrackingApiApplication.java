package css.neu.edu.cs5500.neufoodtruck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// Spring boot application entrance
@EnableJpaRepositories(basePackages = "css.neu.edu.cs5500.neufoodtruck.dao")
@SpringBootApplication
public class AnimalTrackingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimalTrackingApiApplication.class, args);
    }
}
