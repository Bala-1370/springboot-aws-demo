package com.example.aws_demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping (value = "/employees")
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping 
    public List<Employee> getAll(){
        return repository.findAll();
    }

    @PostMapping 
    public Employee create(@RequestBody Employee employee){
        employee.setId(null);
        return repository.save(employee);
    }
    
}
