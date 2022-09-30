package com.eql.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception{

        security.csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/register/**").permitAll()
                .antMatchers("/index").permitAll()
                .antMatchers("/users").hasRole("GM")
                .antMatchers("/perso/**").hasRole("USER")
                .antMatchers("/userHomepage").hasRole("USER")
                .antMatchers("/GMHomepage").hasRole("GM")
                .antMatchers("/battle").hasRole("USER")
                .antMatchers("/enterSession").hasRole("USER")
                .antMatchers("/equipView").hasRole("USER")
                .antMatchers("/listPerso").hasRole("USER")
                .antMatchers("/newSession").hasRole("GM")
                .antMatchers("/play/**").hasRole("USER")
                .antMatchers("/playSession").hasRole("USER")
                .antMatchers("/raceInfo").permitAll()
                .antMatchers("/sessions").hasRole("GM")
                .antMatchers("/showPerso").hasRole("USER")
                .antMatchers("/statView").hasRole("USER")
                .antMatchers("/viewSession").hasRole("GM")
                .and()
                .formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .successHandler(new SecurityHandler())
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return security.build();
    }
}