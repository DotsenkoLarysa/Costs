package com.dots;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.dots.persistence.repo")
@EntityScan("com.dots.model")
@SpringBootApplication
public class CostsApplication {

    public static void main(String[] args) {

        SpringApplication.run(CostsApplication.class, args);
    }

}
