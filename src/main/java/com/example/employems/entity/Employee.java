package com.example.employems.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "Employee")
public class Employee {

    @Id
    private int empID;
    private String empName;
    private String empAddress;
    private String empNumber;
    
}
