package com.oksana.web;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import lombok.var;


@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Bean
	public LocaleResolver localeResolver() {
		var slr = new SessionLocaleResolver();
		slr.setDefaultLocale(new Locale("es"));
		return slr;
	}
	//interceptor para cambiar el idioma dinamicamente
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		var lci = new LocaleChangeInterceptor ();
		lci.setParamName("lang");
		return lci;
	}
	//registramos interceptor
	@Override
	public void addInterceptors(InterceptorRegistry registro) {
		registro.addInterceptor(localeChangeInterceptor());
		
	}
	 @Override
	 public void addViewControllers(ViewControllerRegistry registro) {
		 registro.addViewController("/").setViewName("inicio");
		 registro.addViewController("/login");  //mapeo a login sin pasar por Controller
	 }
	 
	 
}
