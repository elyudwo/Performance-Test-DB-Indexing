package kr.co.dbindexingtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DbIndexingTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbIndexingTestApplication.class, args);
    }

}
