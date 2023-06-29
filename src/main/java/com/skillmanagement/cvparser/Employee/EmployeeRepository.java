package com.skillmanagement.cvparser.Employee;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
    @Query("SELECT e FROM Employee e WHERE e.email =?1")
    Optional<Employee> findEmployeeByEmail(String email);
    
}
