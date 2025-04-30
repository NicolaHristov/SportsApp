package bg.softuni.sportsapptraining;

import bg.softuni.sportsapptraining.config.AdminUserProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AdminUserProperties.class)
public class SportsAppTrainingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportsAppTrainingApplication.class, args);
    }

}
