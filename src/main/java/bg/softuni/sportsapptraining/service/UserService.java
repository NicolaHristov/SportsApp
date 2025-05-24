package bg.softuni.sportsapptraining.service;

import bg.softuni.sportsapptraining.model.User;
import bg.softuni.sportsapptraining.model.dto.RegisterDto;
import bg.softuni.sportsapptraining.model.enums.Role;
import bg.softuni.sportsapptraining.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean register(RegisterDto data) {
        Optional<User> existingUser = userRepository.findByUsernameOrEmail(data.getUsername(), data.getEmail());

        if (existingUser.isPresent()) {
            return false;
        }

        User user = new User();

        user.setUsername(data.getUsername());
        user.setEmail(data.getEmail());
        user.setRole(Role.ROLE_USER);
        user.setPassword(passwordEncoder.encode(data.getPassword()));

        this.userRepository.save(user);

        return true;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void changeUserRole(Long userId, Role newRole) {
        userRepository.findById(userId)
                .filter(user -> user.getRole() != newRole)
                .map(user -> {
                    user.setRole(newRole);
                    userRepository.save(user);
                    return true;
                });
//        Optional<User> userOpt = userRepository.findById(userId);
//
//        if (userOpt.isEmpty()) {
//            return false;
//        }
//
//        User user = userOpt.get();
//        if (user.getRole() == newRole) {
//            return false;
//        }
//
//        user.setRole(newRole);
//        userRepository.save(user);
//
//        return true;
    }


    public Optional<User> findUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found with username: " + username));
    }
}
