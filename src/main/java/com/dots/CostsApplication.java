package com.dots;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.dots.persistence.repo")
@ComponentScan("com.dots.persistence.model")
@SpringBootApplication
public class CostsApplication {

    public static void main(String[] args) {

        SpringApplication.run(CostsApplication.class, args);
    }

}
