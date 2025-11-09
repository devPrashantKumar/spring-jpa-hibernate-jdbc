package com.thecodeexperience.JPADemo04;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
public class JpaDemo04Application {

	public static void main(String[] args) {
		SpringApplication.run(JpaDemo04Application.class, args);
	}

    @Bean
    public CommandLineRunner logDataSource(DataSource dataSource) throws SQLException {
        return args -> System.out.println("Connected to: " + dataSource.getConnection().getMetaData().getURL());
    }

}


