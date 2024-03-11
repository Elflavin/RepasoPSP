package org.educa.examen.configuration;

import lombok.Getter;
import org.educa.examen.security.SecurityUtil;
import org.educa.examen.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Getter
@EnableWebSecurity
@Configuration
public class SpringSecurityConfig {

    private final UserService userService;

    @Autowired
    public SpringSecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Bean
    //TODO: Completa la configuración para filtrar las peticiones según los roles
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors(AbstractHttpConfigurer::disable).csrf(AbstractHttpConfigurer::disable)
                .httpBasic(withDefaults()).authorizeHttpRequests(
                        request ->request.requestMatchers("/client/create").hasAnyRole("ADMIN", "PERSONAL")
                                .requestMatchers("/client/total").permitAll()
                                .requestMatchers("/client/find").hasAnyRole("ADMIN", "PERSONAL")
                                .anyRequest().authenticated());
        return http.build();
    }


    public SecurityUtil passwordEncoder() {
        return new SecurityUtil();
    }

}

