package com.haubui.sample.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Configuration
public class ApplicationConfiguration implements ServletContextInitializer {

    @Autowired
    private Environment env;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        if (env.getActiveProfiles().length != 0) {
            _log.info("Web application configuration, using profiles: {}", (Object[]) env.getActiveProfiles());
        }

        _log.info("Web application fully configured.");
    }

    private static final Logger _log = LoggerFactory.getLogger(ApplicationConfiguration.class);
}
