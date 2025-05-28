package bg.softuni.sportsapptraining.config;

import bg.softuni.sportsapptraining.model.User;
import bg.softuni.sportsapptraining.model.enums.Role;
import bg.softuni.sportsapptraining.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataConfig {

    @Bean
    public CommandLineRunner seedAdmin(UserRepository userRepo, PasswordEncoder encoder, AdminUserProperties props, Environment env) {

        return args -> {
            if (userRepo.findByUsername(props.getUsername()).isEmpty()) {
                User admin = new User();
                admin.setUsername(props.getUsername());
                admin.setEmail(props.getEmail());
                admin.setPassword(encoder.encode(props.getPassword()));
                admin.setRole(Role.ROLE_ADMIN);
                userRepo.save(admin);
            }
        };
    }



}
