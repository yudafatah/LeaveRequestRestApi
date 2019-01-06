/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.leaverequestmaven.repository;

import com.mii.leaverequestmaven.model.LeaveRequest;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
/**
 *
 * @author yudafatah
 */
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Integer>{
    @Query("SELECT l FROM LeaveRequest l WHERE l.lrId = :lrId")
    public List<LeaveRequest> getAllsById(@Param("lrId") Integer lrId);
}
