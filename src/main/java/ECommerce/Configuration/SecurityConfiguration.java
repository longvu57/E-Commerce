package ECommerce.Configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	@Autowired
    public SecurityConfiguration(AuthenticationSuccessHandler authenticationSuccessHandler) {
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }
    @Autowired
    private DataSource dataSource;
     
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
            .dataSource(dataSource)
            .usersByUsernameQuery("select username, password, enabled from users where username=?")
            .authoritiesByUsernameQuery("select username, role from users where username=?")
        ;
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
		.and().authorizeRequests().antMatchers("/").permitAll()
		.and().authorizeRequests().antMatchers("/home").permitAll()
		.and().authorizeRequests().antMatchers("/login").permitAll()
		.and().authorizeRequests().antMatchers("/register").permitAll()
		.and().authorizeRequests().antMatchers("/about").permitAll()
		.and().authorizeRequests().antMatchers("/product-detail").permitAll()
		.and().authorizeRequests().antMatchers("/sort-product").permitAll()
		.and().authorizeRequests().antMatchers("/**").hasRole("USER")

		.and().formLogin().loginPage("/login")
		.loginProcessingUrl("/login").usernameParameter("username").passwordParameter("password")
		.successHandler(authenticationSuccessHandler).failureUrl("/login?error=failed").and().exceptionHandling().accessDeniedPage("/404");
	}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/assets/**");
	}
}
