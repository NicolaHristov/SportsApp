package com.nikola.sportsapp.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterDto {

    @NotNull
    @Size(min = 2, max = 30)
    private String username;
    @Email
    @NotNull
    @Size(min = 6, max = 254)
    private String email;
    @NotNull
    @Size(min = 3, max = 20)
    private String password;
    private String confirmPassword;

}
