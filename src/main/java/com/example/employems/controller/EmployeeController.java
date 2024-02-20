package com.example.employems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employems.dto.EmployeeDTO;
import com.example.employems.dto.ResponseDTO;
import com.example.employems.service.EmployeeService;
import com.example.employems.util.VarList;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;


    @PostMapping(value = "/saveEmployee")
    public ResponseEntity<ResponseDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        try {
            String res = employeeService.saveEmployee(employeeDTO);
            ResponseDTO responseDTO = new ResponseDTO();

            if (res.equals(VarList.RSP_SUCCESS)) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(employeeDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
            } else if (res.equals(VarList.RSP_DUPLICATED)) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Employee Registered");
                responseDTO.setContent(employeeDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
            } else {
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/updateEmployee")
    public ResponseEntity<ResponseDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        try {
            String res = employeeService.updateEmployee(employeeDTO);
            ResponseDTO responseDTO = new ResponseDTO();
    
            if (res.equals(VarList.RSP_SUCCESS)) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(employeeDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
            } else if (res.equals(VarList.RSP_DUPLICATED)) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Employee Registered");
                responseDTO.setContent(employeeDTO);
                return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
            } else {
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("getAllEmployees")
    public ResponseEntity<ResponseDTO> getAllEmployees() {
        try {
            List<EmployeeDTO> employeeDTOList = employeeService.getAllEmployee();
            ResponseDTO responseDTO = new ResponseDTO(); 

            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("Success");
            responseDTO.setContent(employeeDTOList); 
            return new ResponseEntity<>(responseDTO, HttpStatus.OK); 

        } catch (Exception ex) {
            ResponseDTO responseDTO = new ResponseDTO(); 
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

        @GetMapping("searchEmployee/{empID}")
        public ResponseEntity<ResponseDTO> searchEmployee(@PathVariable int empID) {
            try {
                EmployeeDTO employeeDTO = employeeService.searchEmployee(empID);
                ResponseDTO responseDTO = new ResponseDTO();
        
                if (employeeDTO != null) {
                    responseDTO.setCode(VarList.RSP_SUCCESS);
                    responseDTO.setMessage("Employee found");
                    responseDTO.setContent(employeeDTO);
                    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
                } else {
                    responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                    responseDTO.setMessage("Employee not found");
                    responseDTO.setContent(null);
                    return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
                }
            } catch (Exception ex) {
                ResponseDTO responseDTO = new ResponseDTO();
                responseDTO.setCode(VarList.RSP_ERROR);
                responseDTO.setMessage(ex.getMessage());
                responseDTO.setContent(null);
                return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        
    
    }
}