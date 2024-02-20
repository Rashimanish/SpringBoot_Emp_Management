package com.example.employems.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.employems.entity.Employee;

public interface EmployeeRepo extends MongoRepository <Employee,Integer>{

    
} 
