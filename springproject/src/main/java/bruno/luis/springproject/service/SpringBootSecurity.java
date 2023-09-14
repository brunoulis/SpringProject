package bruno.luis.springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringBootSecurity implements WebSecurityConfigurer {

    @Autowired
    private UserDetailsService userDetailService;

    @Override
    public void init(SecurityBuilder builder) throws Exception {
        ((AuthenticationManagerBuilder) builder).userDetailsService(userDetailService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(SecurityBuilder builder) throws Exception {
        ((HttpSecurity) builder).authorizeRequests()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/products/**").hasRole("ADMIN")
                .and().formLogin().loginPage("/user/login")
                .permitAll().defaultSuccessUrl("/user/access");
    }

    @Bean
    public BCryptPasswordEncoder getEnecoder() {
        return new BCryptPasswordEncoder();
    }

}