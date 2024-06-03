package org.example.student.demostudent;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class Config {
    @Bean
    CommandLineRunner commandLineRunner(Repository repository){
        return args -> {
            Model varma = new Model(
						1L,
						"Sai Karthik Varma",
						"karthik@gmail.com",
						LocalDate.of(2001, Month.JUNE, 21)
            );
            repository.saveAll(
                    List.of(varma)
            );


        };
    }
}
