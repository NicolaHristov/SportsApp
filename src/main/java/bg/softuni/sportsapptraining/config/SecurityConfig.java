    package bg.softuni.sportsapptraining.config;

    import bg.softuni.sportsapptraining.repository.UserRepository;
    import bg.softuni.sportsapptraining.service.CustomUserDetailsService;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.http.HttpMethod;
    import org.springframework.security.authentication.AuthenticationManager;
    import org.springframework.security.authentication.ProviderManager;
    import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
    import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
    import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
    import org.springframework.security.config.http.SessionCreationPolicy;
    import org.springframework.security.core.userdetails.User;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.security.core.userdetails.UserDetailsService;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.security.provisioning.InMemoryUserDetailsManager;
    import org.springframework.security.web.SecurityFilterChain;

    @Configuration
    @EnableMethodSecurity
    public class SecurityConfig {

//        @Bean
//        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//            http
//                    .csrf(AbstractHttpConfigurer::disable)
//                    .authorizeHttpRequests(auth -> auth
//                            .requestMatchers("/", "/home", "/index", "/register", "/upload", "/athletics", "/swimming", "/login").permitAll()
//                            .requestMatchers(HttpMethod.POST, "/register").permitAll()
//                            .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
//                            .requestMatchers("/admin/**").hasRole("ADMIN")
//                            .requestMatchers(HttpMethod.POST, "/comments").authenticated()
//                            .anyRequest().authenticated()
//                    )
//    //                .formLogin(login -> login
//    //                        .loginPage("/login")
//    //                        .defaultSuccessUrl("/home", true)
//    //                        .failureUrl("/login?error=true")
//    //                        .permitAll()
//    //                )
//                    .logout(logout -> logout
//                            .logoutUrl("/logout")
//                            .logoutSuccessUrl("/")
//                            .permitAll()
//                    )
//                    .sessionManagement(session -> session
//                            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//                    );
//
//            return http.build();
//        }

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


        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
            return config.getAuthenticationManager();
        }


    }
