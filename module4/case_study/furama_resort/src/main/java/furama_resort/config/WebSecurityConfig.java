package furama_resort.config;

import furama_resort.model.service.impl.user.MyUserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailServiceImpl myUserDetailService;
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/").permitAll()
        .and()
                .authorizeRequests().antMatchers("/employee-list","/employee-edit","/employee-create").hasRole("ADMIN")
                .antMatchers("/").permitAll();
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
        http.authorizeRequests().and().rememberMe()
                .tokenRepository(this.persistentTokenRepository()).tokenValiditySeconds(60*60*24)
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/");
    }
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memoryTokenRepository = new InMemoryTokenRepositoryImpl();
        return memoryTokenRepository;
    }

}
