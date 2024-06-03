package com.Flower.flowerShop.Config;

import com.Flower.flowerShop.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                .requestMatchers("/").permitAll()
                    .requestMatchers("/contact").permitAll()
                    .requestMatchers("/join").permitAll()
                    .requestMatchers("/signup").permitAll()
                    .requestMatchers("/signup-success").permitAll()


                    .requestMatchers("/index").authenticated()

                .anyRequest().authenticated()
             );


        /*
       ## 스프링 버젼을 높은것을 쓴다면
       ## Override -> Bean등록으로 변경
       ## authorizeRequests() -> authorizeHttpRequests()
       ## antMatchers() -> requestMatchers()
       ## access() -> hasAnyRole()
       ## http.build()를 꼭 반환해 줘야함
        */


        http .csrf(cors -> cors.disable())
             .cors(cors -> cors.disable());

        return http.build();
    }

}

