package bg.softuni.sportsapptraining.service;

import bg.softuni.sportsapptraining.model.User;
import bg.softuni.sportsapptraining.model.dto.RegisterDto;
import bg.softuni.sportsapptraining.model.enums.Role;
import bg.softuni.sportsapptraining.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.security.access.AccessDeniedException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean register(RegisterDto data) {
        Optional<User> existingUser =
                userRepository.findByUsernameOrEmail(data.getUsername(), data.getEmail());

        if (existingUser.isPresent()) {
            return false;
        }

        User user = new User();
        user.setUsername(data.getUsername());
        user.setEmail(data.getEmail());
        user.setRole(Role.ROLE_USER);
        user.setPassword(passwordEncoder.encode(data.getPassword()));
        userRepository.save(user);

        return true;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public void changeUserRole(Long targetUserId, Role newRole) throws AccessDeniedException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String actorUsername = auth.getName();
        User actor = userRepository.findByUsername(actorUsername)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Actor not found: " + actorUsername));

        User target = userRepository.findById(targetUserId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Target user not found: " + targetUserId));

        if (target.getRole() == Role.ROLE_SUPER_ADMIN) {
            throw new AccessDeniedException(
                    "Cannot change role of Super-Admin");
        }

        if (newRole == Role.ROLE_SUPER_ADMIN) {
            throw new AccessDeniedException(
                    "Not allowed to assign new Super-Admin");
        }

        if (actor.getRole() == Role.ROLE_ADMIN) {
            boolean allowed = newRole == Role.ROLE_USER
                    || newRole == Role.ROLE_ADMIN;
            if (!allowed) {
                throw new AccessDeniedException(
                        "Admin can only change roles between USER and ADMIN");
            }
        }

        target.setRole(newRole);
        userRepository.save(target);
    }

    public Optional<User> findUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new IllegalArgumentException("User not found: " + username));
    }


}
