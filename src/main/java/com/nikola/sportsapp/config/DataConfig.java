package com.nikola.sportsapp.config;

import com.nikola.sportsapp.model.User;
import com.nikola.sportsapp.model.enums.Role;
import com.nikola.sportsapp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
