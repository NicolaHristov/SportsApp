    package com.nikola.sportsapp.config;

    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.http.HttpMethod;
    import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.config.http.SessionCreationPolicy;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.security.web.SecurityFilterChain;

    @Configuration
    @EnableMethodSecurity
    public class SecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers(HttpMethod.GET,
                                    "/", "/home", "/index", "/login", "/register",
                                    "/athletics", "/swimming",
                                    "/css/**", "/js/**", "/images/**"
                            ).permitAll()
                            .requestMatchers(HttpMethod.POST, "/athletics", "/swimming").permitAll()
                            .requestMatchers(HttpMethod.POST, "/register", "/login").permitAll()
                            .requestMatchers(HttpMethod.POST, "/comments").authenticated()
                            .requestMatchers("/admin/**").hasAnyRole("ADMIN","SUPER_ADMIN")
                            .requestMatchers("/upload", "/upload-form").authenticated()
                            .anyRequest().authenticated()
                    )
                    .formLogin(form -> form
                            .loginPage("/login")
                            .loginProcessingUrl("/login")
                            .defaultSuccessUrl("/home", true)
                            .permitAll()
                    )

                    .logout(logout -> logout
                            .logoutUrl("/logout")
                            .logoutSuccessUrl("/home")
                            .permitAll()
                    )
                    .sessionManagement(sess ->
                            sess.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                    );

            return http.build();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

    }
