/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.leaverequestmaven.controller;

import com.mii.leaverequestmaven.DAO.LeaveRequestTypeDAO;
import com.mii.leaverequestmaven.model.LeaveRequestType;
import com.mii.leaverequestmaven.model.ServiceResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author yudafatah
 */
@RestController
@RequestMapping("/lrt")
public class LeaveRequestTypeController {
    @Autowired
    LeaveRequestTypeDAO lrtdao;
    
    /*get all employees*/
    @GetMapping("/leaverequesttypes")
    public ResponseEntity<Object> getAllLeaveRequest() {
        ServiceResponse<List<LeaveRequestType>> response = new ServiceResponse<>("success", lrtdao.findAll());
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }
}
