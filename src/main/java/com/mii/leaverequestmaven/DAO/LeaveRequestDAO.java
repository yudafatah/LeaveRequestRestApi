/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.leaverequestmaven.DAO;

import com.mii.leaverequestmaven.model.LeaveRequest;
import com.mii.leaverequestmaven.repository.LeaveRequestRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yudafatah
 */
@Service
public class LeaveRequestDAO {
    @Autowired
    LeaveRequestRepository er;

    public LeaveRequest save(LeaveRequest lr) {
        return er.save(lr);
    }

    public List<LeaveRequest> findAll() {
        return er.findAll();
    }

    public LeaveRequest findOne(Integer id) {
        return er.findOne(id);
    }

    public void delete(LeaveRequest lr) {
        er.delete(lr);
    }
    
    public List<LeaveRequest> getAllsById(Integer id){
        return er.getAllsById(id);
    }
}
