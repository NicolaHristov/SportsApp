package bg.softuni.sportsapptraining.config;

import bg.softuni.sportsapptraining.model.User;
import bg.softuni.sportsapptraining.model.enums.Role;
import bg.softuni.sportsapptraining.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataConfig {

    @Bean
    public CommandLineRunner seedSuperAdmin(UserRepository userRepo,
                                            PasswordEncoder encoder,
                                            SuperAdminProperties props) {
        return args -> {
            if (userRepo.findByUsername(props.getUsername()).isEmpty()) {
                User superAdmin = new User();
                superAdmin.setUsername(props.getUsername());
                superAdmin.setEmail(props.getEmail());
                superAdmin.setPassword(encoder.encode(props.getPassword()));
                superAdmin.setRole(Role.ROLE_SUPER_ADMIN);
                userRepo.save(superAdmin);
            }
        };
    }

}
