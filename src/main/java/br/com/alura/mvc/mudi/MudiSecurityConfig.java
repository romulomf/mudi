package br.com.alura.mvc.mudi;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MudiSecurityConfig {

	public MudiSecurityConfig() {
		// construtor padrão
	}

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.authorizeHttpRequests(requests -> requests
			.antMatchers("/home/**").permitAll()
			.anyRequest().authenticated())
			.formLogin(form -> form.loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/usuario/pedido", true).permitAll())
			.logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/home").permitAll())
			.csrf(conf -> conf.disable())
			.build();
	}

	@Bean
	AuthenticationManager authManager(HttpSecurity http, BCryptPasswordEncoder passwordEncoder, @Autowired DataSource dataSource) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class)
					.jdbcAuthentication()
					.dataSource(dataSource)
					.passwordEncoder(passwordEncoder)
				.and()
					.build();
	}

	@Bean
	WebSecurityCustomizer webSecurityCustomizer() {
		return web -> web.debug(false).ignoring().antMatchers("/login/**");
	}
}