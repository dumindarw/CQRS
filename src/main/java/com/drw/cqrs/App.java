package com.drw.cqrs;

import com.drw.cqrs.commands.DocumentDAOImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = DocumentDAOImpl.class)
@MapperScan("com.drw.cqrs.queries")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
