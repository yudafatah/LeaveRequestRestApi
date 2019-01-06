/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.leaverequestmaven.repository;

import com.mii.leaverequestmaven.model.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yudafatah
 */
public interface ParameterRepository extends JpaRepository<Parameter, Integer>{
    
}
