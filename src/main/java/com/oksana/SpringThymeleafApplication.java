package com.oksana;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Main
 *
 * @author Oksana Yurkiv
 */
@SpringBootApplication
public class SpringThymeleafApplication {

    public static void main(String[] args) {
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
        new SpringApplicationBuilder(SpringThymeleafApplication.class).web(WebApplicationType.SERVLET).run(args);

    }

}
