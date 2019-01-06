/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.leaverequestmaven.DAO;

import com.mii.leaverequestmaven.model.Employee;
import com.mii.leaverequestmaven.repository.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yudafatah
 */
@Service
public class EmployeeDAO {
    @Autowired
    EmployeeRepository er;

    public Employee save(Employee emp) {
        return er.save(emp);
    }

    public List<Employee> findAll() {
        return er.findAll();
    }

    public Employee findOne(Integer id) {
        return er.findOne(id);
    }

    public void delete(Employee emp) {
        er.delete(emp);
    }
    public Employee getByEmail(String email){
        return er.getByEmail(email);
    }
}
