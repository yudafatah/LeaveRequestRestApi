/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.leaverequestmaven.repository;

import com.mii.leaverequestmaven.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
/**
 *
 * @author yudafatah
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    public Employee getByEmail(@Param("email") String email);
}
