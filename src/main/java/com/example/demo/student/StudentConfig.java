package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mariam = new Student(
                    "Mariam",
                    LocalDate.of(2000, JANUARY, 5),
                    "mariam.jamal@gmail.com"
            );
            Student john = new Student(
                    "John",
                    LocalDate.of(2005, FEBRUARY, 28),
                    "john.jamal@gmail.com"
            );

            repository.saveAll(
                    List.of(mariam, john)
            );
        };
    }
}
