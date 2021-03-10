package com.oksana.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity   //para habilitar la seguridad web
public class SecurityConfig extends WebSecurityConfigurerAdapter  {    //para configurar los usuarios
	
	//Autenticación
	//el metodo sirve para agregar más usuarios y personalizar
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
	// Autorización	
	// sirve para restringir las urls de la app
	@Override
	protected void configure (HttpSecurity http) throws Exception {
		 http.authorizeRequests()
		 	   .antMatchers("/editar/**", "/agregar/**", "/eliminar")  //  doble asterisco ** significa que sub-path tambien van a estar restringidos
		 		   .hasRole("ADMIN") // solo rol ADMIN pueden acceder a paths editar, agregar, eliminar
		 	   .antMatchers("/") // path raiz
		 		   .hasAnyRole("USER", "ADMIN")//no hace falta especificar ROLE_USER etc. ya que Spring lo hace en automatico	 
		 	   .and()
		 	   		.formLogin()
		 	   		.loginPage("/login")
		 	   	.and()
		 	   		.exceptionHandling().accessDeniedPage("/errores/403")
		      ; 
		  
	 }
	}

