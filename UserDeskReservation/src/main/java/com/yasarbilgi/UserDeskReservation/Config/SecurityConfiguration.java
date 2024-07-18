package com.yasarbilgi.UserDeskReservation.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    UserDetailsService userDetailsService() {
        //Kullanıcı adı ve şifre bilgileri:
        var user = User.withUsername("office").password("123456").authorities("read").build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //Parolaları şifresiz saklıyor(ByCryptEncoder öneriliyor)
        return NoOpPasswordEncoder.getInstance();
    }
    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults());
        // Tüm endpointler için doğrulamaya gerek yok!!!
        http.authorizeHttpRequests(c -> c.anyRequest().permitAll());
        return http.build();
    }
}
