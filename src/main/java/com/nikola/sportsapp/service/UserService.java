package com.nikola.sportsapp.service;

import com.nikola.sportsapp.model.User;
import com.nikola.sportsapp.model.dto.RegisterDto;
import com.nikola.sportsapp.model.enums.Role;
import com.nikola.sportsapp.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.security.access.AccessDeniedException;

import java.util.List;
import java.util.Optional;

import static com.nikola.sportsapp.constant.ExceptionMessages.*;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public boolean register(RegisterDto data) {
        Optional<User> existingUser =
                userRepository.findByUsernameOrEmail(data.getUsername(), data.getEmail());

        if (existingUser.isPresent()) {
            return false;
        }

        User user = modelMapper.map(data, User.class);
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
                        ACTOR_NOT_FOUND + actorUsername));

        User target = userRepository.findById(targetUserId)
                .orElseThrow(() -> new EntityNotFoundException(
                        TARGET_USER_NOT_FOUND + targetUserId));

        if (target.getRole() == Role.ROLE_SUPER_ADMIN) {
            throw new AccessDeniedException(
                    SUPER_ADMIN_CHANGE_DENIED);
        }

        if (newRole == Role.ROLE_SUPER_ADMIN) {
            throw new AccessDeniedException(
                    SUPER_ADMIN_ASSIGN_DENIED);
        }

        if (actor.getRole() == Role.ROLE_ADMIN) {
            boolean allowed = newRole == Role.ROLE_USER
                    || newRole == Role.ROLE_ADMIN;
            if (!allowed) {
                throw new AccessDeniedException(
                        ADMIN_ROLE_CHANGE_LIMITATION);
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
                        new IllegalArgumentException(USER_NOT_FOUND + username));
    }


}
