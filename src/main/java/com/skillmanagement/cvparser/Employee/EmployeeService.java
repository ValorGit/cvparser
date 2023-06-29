package com.skillmanagement.cvparser.Employee;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

     private final EmployeeRepository EmployeeRepository;


	public EmployeeService(EmployeeRepository EmployeeRepository) {
        this.EmployeeRepository = EmployeeRepository;
    }


    public List<Employee> getEmployees(){
		return EmployeeRepository.findAll();
	}


    public void addNewEmployee(Employee Employee) {
        Optional<Employee> EmployeeByEmail =
        EmployeeRepository.findEmployeeByEmail(Employee.getEmail());
        if(EmployeeByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        EmployeeRepository.save(Employee);
        System.out.println(Employee);

    }


    public void deleteEmployee(Long EmployeeId) {
        boolean Employeeexists = EmployeeRepository.existsById(EmployeeId);
        if(!Employeeexists){
            throw new IllegalStateException("Employee with id" + EmployeeId + "does not exist");
        }
        EmployeeRepository.deleteById(EmployeeId);
    }

    @Transactional
    public void updateEmployee(Long employeeId, String name, String email) {
          Employee employee =  EmployeeRepository.findById(employeeId).orElseThrow(() -> new IllegalStateException("Employee with id" + employeeId + "does not exist"));
        
        if(name != null && name.length() != 0 && !Objects.equals(name, employee.getName())){
            employee.setName(name);
        }

        if(email != null && email.length() != 0 && !Objects.equals(email, employee.getEmail())){
        Optional<Employee> EmployeeByEmail =
        EmployeeRepository.findEmployeeByEmail(employee.getEmail());
        if(EmployeeByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
            
        }
        employee.setEmail(email);
    }
    
    
}
    
}
