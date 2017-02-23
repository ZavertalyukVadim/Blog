package blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("root").password("root").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin").access("hasRole('ADMIN')")
                .antMatchers("/user").access("hasRole('USER')")
                .antMatchers("/post/newPost","/tag/newTag","/category/newCategory").access("hasRole('ADMIN')")
                .antMatchers("/post/**").access("hasRole('USER')")
                .antMatchers("/tag/**").access("hasRole('USER')")
                .antMatchers("/category/**").access("hasRole('USER')")
//                .and().formLogin().loginPage("/login")
                .and().formLogin()
                .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }
}
