package com.philip.khzExamen.config;



import com.philip.khzExamen.service.UserEntityDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import java.util.concurrent.TimeUnit;
import static com.philip.khzExamen.models.Roles.*;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity               // Enables use of @PreAuthorize
public class AppSecurityConfig {

    // Info about Authentication & Authorities:
    // Authentication - identity (Are you who you say you are?) // I am Batman (Username & Password)
    // Authorities - Role & Permissions
    //      ROLE_ADMIN  == GET, POST, PUT, DELETE
    //      ROLE_BATMAN == GET, POST, PUT
    //      ROLE_USER   == GET, POST
    //      ROLE_GUEST  == GET

    private final AppPasswordConfig appPasswordConfig;
    private final UserEntityDetailsService userEntityDetailsService;

    @Autowired
    public AppSecurityConfig(AppPasswordConfig appPasswordConfig, UserEntityDetailsService userEntityDetailsService) {
        this.appPasswordConfig = appPasswordConfig;
        this.userEntityDetailsService = userEntityDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)                  // Can cause 403 Forbidden
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/hash", "/register", "/api/user").permitAll()
                        .requestMatchers("/home-page").hasRole(ADMIN.name())
//                        .requestMatchers("/cars").hasRole(ADMIN.name())
//                        .requestMatchers("/customers").hasRole(ADMIN.name())
//                        .requestMatchers("/orders").hasRole(ADMIN.name())


                        .anyRequest().permitAll()
                )

                .formLogin( formLogin -> formLogin
                                .loginPage("/login")
                                .defaultSuccessUrl("/admin")// Override /login
                        // .usernameParameter("email")
                )

                .rememberMe(rememberMe -> rememberMe
                        .tokenValiditySeconds(Math.toIntExact(TimeUnit.DAYS.toSeconds(21)))    // TODO - Do not like casting
                        .key("someSecureKey")                                                     // TODO - Change to some secure key
                        .userDetailsService(userEntityDetailsService)
                        .rememberMeParameter("remember-me")
                )

                .logout( logout -> logout
                        .logoutUrl("/perform_logout")
                        .clearAuthentication(true)
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID", "remember-me")
                        .logoutSuccessUrl("/login")
                )

                .authenticationProvider(daoAuthenticationProvider())    // Tell Spring to use our implementation (Password & Service)
                .build();
    }

    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setPasswordEncoder(appPasswordConfig.bCryptPasswordEncoder());
        provider.setUserDetailsService(userEntityDetailsService);

        return provider;
    }


}

