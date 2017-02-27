package blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
//        auth.inMemoryAuthentication().withUser("root").password("root").roles("USER");
//        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/admin").access("hasRole('ADMIN')")
                .antMatchers("/post/newPost").access("hasRole('USER')")
                .antMatchers("/tag/newTag","/category/newCategory").access("hasRole('ADMIN')")
                .antMatchers("/post/**").access("hasRole('USER') or hasRole('ADMIN')")
                .antMatchers("/tag/**").access("hasRole('USER') or hasRole('ADMIN')")
                .antMatchers("/category/**").access("hasRole('USER') or hasRole('ADMIN')")
//                .and().formLogin().loginPage("/login")
                .and().formLogin()
                .and().csrf()
                .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }
}
