package com.oksana.infrastructure.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * SecurityConfig
 * Se habilita la seguridad web con @EnableWebSecurity
 * Se configurar los usuarios con WebSecurityConfigurerAdapter
 *
 * @author Oksana Yurkiv
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	/*Autenticación
	el metodo sirve para agregar más usuarios y personalizar
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
		auth.inMemoryAuthentication()
			.withUser("admin")
				.password("{noop}123") //noop -significa que no es necesario encriptar el password
				.roles("ADMIN","USER")
			.and()
			.withUser("user")
				.password("{noop}123")
				.roles("USER")
         ;
	}
	*/

    //TODO: en vez de  @Autowired usar constructor
    //revisar en todo proyecto

    //inyectamos el servicio de usuario
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    /**
     * Security config.
     * Autorización - sirve para restringir las urls de la app
     *
     * @param http HttpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /**
         * Si los roles de usuarios en la base de datos están almacenados como ADMIN o USER sin el prefijo ROLE_, Spring Security no los reconocerá correctamente.
         */
        http.authorizeRequests()
                .antMatchers("/editar/**", "/agregar/**", "/eliminar").hasRole("ADMIN")
                .antMatchers("/").hasAnyRole("USER", "ADMIN")
                .antMatchers("/h2-console/**").permitAll() // Permitir acceso libre a H2-console
                .and()
                .csrf().ignoringAntMatchers("/h2-console/**") // Desactivar CSRF solo para H2
                .and()
                .headers().frameOptions().disable() // Permitir el uso de frames para H2
                .and()
                .formLogin().loginPage("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/errores/403");

    }
}

