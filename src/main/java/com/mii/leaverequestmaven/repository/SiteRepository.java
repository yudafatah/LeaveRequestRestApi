/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.leaverequestmaven.repository;

import com.mii.leaverequestmaven.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author yudafatah
 */
public interface SiteRepository extends JpaRepository<Site, Integer>{
    
}
