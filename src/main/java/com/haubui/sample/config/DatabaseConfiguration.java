package com.haubui.sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.haubui.sample.repository")
@EnableTransactionManagement
public class DatabaseConfiguration {
}
