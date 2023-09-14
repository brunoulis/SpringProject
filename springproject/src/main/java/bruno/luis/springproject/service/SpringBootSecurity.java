package bruno.luis.springproject.service;

/*
 * Esta clase es una clase de configuración de Spring Security.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringBootSecurity {

    @Autowired
    private UserDetailsService userDetailService;

    /*
     * Este método crea un bean de `BCryptPasswordEncoder`.
     */
    @Bean
    public BCryptPasswordEncoder getEnecoder() {
        return new BCryptPasswordEncoder();
    }

    /*
     * Este método crea un bean de `SecurityFilterChain`.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /*
         * Este método define que las demás rutas pueden ser accedidas por cualquier
         * usuario.
         * Este método define que las rutas `/admin/**` y `/products/**` solo pueden ser
         * accedidas por usuarios con el rol `ADMIN`.
         */
        return http.authorizeRequests().requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/products/**").hasRole("ADMIN").and().formLogin().loginPage("/user/login")
                .permitAll().defaultSuccessUrl("/user/access").and().build();
    }

}
