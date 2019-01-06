/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.leaverequestmaven.controller;

import com.mii.leaverequestmaven.DAO.EmployeeDAO;
import com.mii.leaverequestmaven.model.Employee;
import com.mii.leaverequestmaven.model.ServiceResponse;
import com.mii.leaverequestmaven.tools.BCrypt;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author yudafatah
 */
@RestController
@RequestMapping("/profile")
public class EmployeeController {

    @Autowired
    EmployeeDAO employeeDAO;
    
    List<Employee> employeesList = new ArrayList<>();

    /* to save an employee*/
    @PostMapping("/employee")
    public Employee createEmployee(@Valid @RequestBody Employee emp) {
        return employeeDAO.save(emp);
    }

    /*get all employees*/
    @GetMapping("/employees")
    public ResponseEntity<Object> getAllBooks() {
        employeesList = employeeDAO.findAll();
        ServiceResponse<List<Employee>> response = new ServiceResponse<>("success", employeesList);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }
//    public List<Employee> getAllEmployees() {
//        ModelAndView mv = new ModelAndView("index");
//        mv.addObject("lists", employeeDAO.findAll());
//        return employeeDAO.findAll();
//    }

    /*get employee by empid*/
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Integer empid) {

        Employee emp = employeeDAO.findOne(empid);

        if (emp == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(emp);
    }
    
    /*get employee by email*/
    @GetMapping("/employeebyemail/{email}")
    public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable(value = "email") String email) {

        Employee emp = employeeDAO.getByEmail(email);

        if (emp == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(emp);
    }
    
    @GetMapping("/employeerelationbyemail/{email}")
    public ResponseEntity<Object> getRelationByEmail(@PathVariable(value = "email") String email) {

        Employee emp = employeeDAO.getByEmail(email);
        String[] relation = {emp.getRoleId().getRoleName(), emp.getSiteId().getSiteName()};
        if (emp == null) {
            return ResponseEntity.notFound().build();
        }
        ServiceResponse<String[]> response = new ServiceResponse<>("success", relation);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    /*update an employee by empid*/
    @PostMapping("/employee/{id}/{name}/{address}/{phone}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") String empid, 
            @PathVariable(value = "name") String name, @PathVariable(value = "address") String address,
            @PathVariable(value = "phone") String phone) {

        Employee emp = employeeDAO.findOne(Integer.parseInt(empid));
        if (emp == null) {
            return ResponseEntity.notFound().build();
        }

        emp.setSiteId(emp.getSiteId());
        emp.setEmployeeName(name);
        emp.setGender(emp.getGender());
        emp.setAddress(address);
        emp.setJoinDate(emp.getJoinDate());
        emp.setEmail(emp.getEmail());
        emp.setManagerId(emp.getManagerId());
        emp.setUsername(emp.getUsername());
        emp.setQuotaThisyear(emp.getQuotaThisyear());
        emp.setPassword(emp.getPassword());
        emp.setRoleId(emp.getRoleId());
        emp.setIsActive(emp.getIsActive());
        emp.setPhone(phone);
        emp.setQuotaLastyear(emp.getQuotaLastyear());

        Employee updateEmployee = employeeDAO.save(emp);
        return ResponseEntity.ok().body(updateEmployee);

    }
    
    @PostMapping("/employeeactivation/{id}/{password}")
    public ResponseEntity<Employee> updateEmployeeActivation(@PathVariable(value = "id") String empid, 
            @PathVariable(value = "password") String pass) {

        Employee emp = employeeDAO.findOne(Integer.parseInt(empid));
        if (emp == null) {
            return ResponseEntity.notFound().build();
        }

        emp.setSiteId(emp.getSiteId());
        emp.setEmployeeName(emp.getEmployeeName());
        emp.setGender(emp.getGender());
        emp.setAddress(emp.getAddress());
        emp.setJoinDate(emp.getJoinDate());
        emp.setEmail(emp.getEmail());
        emp.setManagerId(emp.getManagerId());
        emp.setUsername(emp.getUsername());
        emp.setQuotaThisyear(emp.getQuotaThisyear());
        emp.setPassword(BCrypt.hashpw(pass, BCrypt.gensalt()));
        emp.setRoleId(emp.getRoleId());
        emp.setIsActive(true);
        emp.setPhone(emp.getPhone());
        emp.setQuotaLastyear(emp.getQuotaLastyear());

        Employee updateEmployee = employeeDAO.save(emp);
        return ResponseEntity.ok().body(updateEmployee);

    }
    
    @PostMapping("/employeeupdatelrquota/{id}/{lrduration}")
    public ResponseEntity<Employee> updateEmployeeLRQuota(@PathVariable(value = "id") String empid, 
            @PathVariable(value = "lrduration") String lrduration) {

        Employee emp = employeeDAO.findOne(Integer.parseInt(empid));
        if (emp == null) {
            return ResponseEntity.notFound().build();
        }

        emp.setSiteId(emp.getSiteId());
        emp.setEmployeeName(emp.getEmployeeName());
        emp.setGender(emp.getGender());
        emp.setAddress(emp.getAddress());
        emp.setJoinDate(emp.getJoinDate());
        emp.setEmail(emp.getEmail());
        emp.setManagerId(emp.getManagerId());
        emp.setUsername(emp.getUsername());
        emp.setQuotaThisyear(Integer.parseInt(lrduration));
        emp.setPassword(emp.getPassword());
        emp.setRoleId(emp.getRoleId());
        emp.setIsActive(emp.getIsActive());
        emp.setPhone(emp.getPhone());
        emp.setQuotaLastyear(emp.getQuotaLastyear());

        Employee updateEmployee = employeeDAO.save(emp);
        return ResponseEntity.ok().body(updateEmployee);

    }

    /*Delete an employee*/
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") Integer empid) {

        Employee emp = employeeDAO.findOne(empid);
        if (emp == null) {
            return ResponseEntity.notFound().build();
        }
        employeeDAO.delete(emp);

        return ResponseEntity.ok().build();

    }
}
