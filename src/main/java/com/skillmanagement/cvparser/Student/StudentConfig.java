package com.skillmanagement.cvparser.Student;

import java.time.LocalDate;
import static java.time.Month.*;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
 
  

    @Bean
    CommandLineRunner cmdLindRunner(StudentRepository studentRepository){
        return args -> {
Student alex = new Student("Alex", "Alex.test@test.de", LocalDate.of(2003, JANUARY, 19));
Student juergen = new Student("Juergen", "juergen.test@test.de", LocalDate.of(1920, FEBRUARY, 19));
studentRepository.saveAll(List.of(alex, juergen));       
};
    }
}
