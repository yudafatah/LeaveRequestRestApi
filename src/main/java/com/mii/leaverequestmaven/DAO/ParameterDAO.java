/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.leaverequestmaven.DAO;

import com.mii.leaverequestmaven.model.Employee;
import com.mii.leaverequestmaven.model.Parameter;
import com.mii.leaverequestmaven.repository.EmployeeRepository;
import com.mii.leaverequestmaven.repository.ParameterRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yudafatah
 */
@Service
public class ParameterDAO {
    @Autowired
    ParameterRepository repository;

    public Parameter save(Parameter p) {
        return repository.save(p);
    }

    public List<Parameter> findAll() {
        return repository.findAll();
    }

    public Parameter findOne(Integer id) {
        return repository.findOne(id);
    }

    public void delete(Parameter p) {
        repository.delete(p);
    }
}
