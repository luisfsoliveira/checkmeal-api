package com.checkmeal;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class CheckMealApplication {
	
	    public static void main(String[] args) {
	        SpringApplication.run(CheckMealApplication.class, args);
	    }
	    
	    @Bean
	    public LocaleResolver localeResolver(){
	    	AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver(); 
	    	localeResolver.setDefaultLocale(Locale.ENGLISH);
	    	return localeResolver;
	    }
	 
}