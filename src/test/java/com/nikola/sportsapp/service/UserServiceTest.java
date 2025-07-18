package com.nikola.sportsapp.service;

import com.nikola.sportsapp.model.User;
import com.nikola.sportsapp.model.dto.RegisterDto;
import com.nikola.sportsapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    void testRegister_WhenUserDoesNotExist_ShouldRegisterSuccessfully() {
        RegisterDto dto = new RegisterDto();
        dto.setUsername("testuser");
        dto.setEmail("test@example.com");
        dto.setPassword("password123");

        when(userRepository.findByUsernameOrEmail("testuser", "test@example.com"))
                .thenReturn(Optional.empty());

        when(passwordEncoder.encode("password123")).thenReturn("encodedPass");

        boolean result = userService.register(dto);

        assertThat(result).isTrue();

        verify(userRepository).save(any(User.class));

    }

}
