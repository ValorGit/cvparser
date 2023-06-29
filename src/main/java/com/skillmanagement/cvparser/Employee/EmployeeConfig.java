package com.skillmanagement.cvparser.Employee;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class EmployeeConfig {
     @Bean
    CommandLineRunner cmdLindRunnerEmployee(EmployeeRepository employeeRespository){
        return args -> {
Employee alex = new Employee("Alex", "Alex.test@test.de");
Employee juergen = new Employee("juergen", "juergen.test@test.de");
employeeRespository.saveAll(List.of(alex, juergen));       
};
    }
}
