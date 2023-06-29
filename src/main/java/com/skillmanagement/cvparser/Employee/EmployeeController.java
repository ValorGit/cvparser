package com.skillmanagement.cvparser.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {

        private final EmployeeService EmployeeService;

    @Autowired
    public EmployeeController(EmployeeService EmployeeService) {
        this.EmployeeService = EmployeeService;
    }

    @GetMapping
	public List<Employee> getEmployees(){
		return EmployeeService.getEmployees();
	}

    @PostMapping
    public void registerNewEmployee(@RequestBody Employee Employee){
        EmployeeService.addNewEmployee(Employee);
    }

    @DeleteMapping(path = "{EmployeeId}")
    public void deleteEmployee(@PathVariable("EmployeeId") Long EmployeeId){
        EmployeeService.deleteEmployee(EmployeeId);

    }

    @PutMapping(path = "{EmployeeId}")
    public void updateEmployee(
        @PathVariable("EmployeeId") Long EmployeeId, 
        @RequestParam(required = false) String name, 
        @RequestParam(required = false) String email){
        
        EmployeeService.updateEmployee(EmployeeId, name, email);
    }
    
}
