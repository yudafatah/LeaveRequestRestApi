/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.leaverequestmaven.controller;

import com.mii.leaverequestmaven.DAO.EmployeeDAO;
import com.mii.leaverequestmaven.model.Employee;
import com.mii.leaverequestmaven.model.LeaveRequest;
import com.mii.leaverequestmaven.model.ServiceResponse;
import com.mii.leaverequestmaven.tools.BCrypt;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author yudafatah
 */
@RestController
@RequestMapping("/acc")
public class AccountController {
    
    @Autowired
    EmployeeDAO edao;
    
    @GetMapping("/account/{email}/{password}")
    public ResponseEntity<Object> getLoginStatus(@PathVariable(value = "email") String email, 
            @PathVariable(value = "password") String password) {
        String result="";
        Employee e = edao.getByEmail(email);
        if(e!=null){
            if(BCrypt.checkpw(password, e.getPassword())){
                result = "success";
            }else{
                result = "Password incorrect";
            }
        }else{
            result = "Email incorrect";
        }
        ServiceResponse<String> response = new ServiceResponse<>("success", result);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }
}
