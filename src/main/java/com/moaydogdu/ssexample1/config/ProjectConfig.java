package com.moaydogdu.ssexample1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig {

    @Bean
    public UserDetailsService userDetailsService(){
        var inMemoryUserDetailsManager = new InMemoryUserDetailsManager();

        var user1 = User.withUsername("moaydogdu")
                .password("1234")
                .authorities("read")
                .build();

        inMemoryUserDetailsManager.createUser(user1);

        return inMemoryUserDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance(); //Deprecated, using for test. Dont use it ever.
    }

}
