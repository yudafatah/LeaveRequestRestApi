/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.leaverequestmaven.DAO;

import com.mii.leaverequestmaven.model.Employee;
import com.mii.leaverequestmaven.model.Role;
import com.mii.leaverequestmaven.repository.EmployeeRepository;
import com.mii.leaverequestmaven.repository.RoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yudafatah
 */
@Service
public class RoleDAO {
    @Autowired
    RoleRepository rr;

    public Role save(Role role) {
        return rr.save(role);
    }

    public List<Role> findAll() {
        return rr.findAll();
    }

    public Role findOne(Integer id) {
        return rr.findOne(id);
    }

    public void delete(Role role) {
        rr.delete(role);
    }
}
