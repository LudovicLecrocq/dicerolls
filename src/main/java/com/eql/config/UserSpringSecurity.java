package com.eql.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@Order(1)
public class UserSpringSecurity {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception{

        security.csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/register/**").permitAll()
                .antMatchers("/index").permitAll()
                .antMatchers("/users").hasRole("ADMIN")
                .antMatchers("/perso/**").hasRole("USER")
                .antMatchers("homepage").hasRole("USER")
                .and()
                .formLogin(
                        form -> form
                                .loginPage("/userLogin")
                                .loginProcessingUrl("/userLogin")
                                .defaultSuccessUrl("/homepage")
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return security.build();
    }
}
