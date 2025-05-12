package com.spring.boot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Hello world!
 *
 */
@Slf4j
@SpringBootApplication
@EntityScan(basePackages = "com.spring.boot")
@EnableJpaRepositories
public class SpringBootApp implements CommandLineRunner {

    public static void main( String[] args ) {
        SpringApplication.run(SpringBootApp.class);
        log.info( "Hello Your SpringBootApp has Initialize!" );
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("--------------------------------");
    }
}
