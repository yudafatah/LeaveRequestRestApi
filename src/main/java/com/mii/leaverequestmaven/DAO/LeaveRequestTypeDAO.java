/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.leaverequestmaven.DAO;

import com.mii.leaverequestmaven.model.Employee;
import com.mii.leaverequestmaven.model.LeaveRequestType;
import com.mii.leaverequestmaven.repository.LeaveRequestTypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yudafatah
 */
@Service
public class LeaveRequestTypeDAO {
    @Autowired
    LeaveRequestTypeRepository lrtr;

    public LeaveRequestType save(LeaveRequestType type) {
        return lrtr.save(type);
    }

    public List<LeaveRequestType> findAll() {
        return lrtr.findAll();
    }

    public LeaveRequestType findOne(Integer id) {
        return lrtr.findOne(id);
    }

    public void delete(LeaveRequestType emp) {
        lrtr.delete(emp);
    }
}
