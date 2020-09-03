package info.vziks.api.config;

import info.vziks.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/registration").not().fullyAuthenticated()
                .antMatchers("/foruser/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/foradmin/**").hasRole("ADMIN")
                .antMatchers("/", "/route/**", "/issues/**", "/content/**").permitAll()
                .antMatchers("/webjars/**", "/js/**", "/css/**", "/img/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error=true")
//                .failureHandler(errorHandler())
                .permitAll()
                .and()
//                "/logout"
                .logout().permitAll()
                .logoutSuccessUrl("/");

    }

    @Override
    public void configure(WebSecurity webSecurity) {
        webSecurity
                .ignoring()
                .antMatchers("/webjars/**",
                        "/js/**", "/css/**", "/img/**")
        ;
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder builder)
            throws Exception {
        builder.userDetailsService(userService).
                passwordEncoder(bCryptPasswordEncoder());
    }
}
