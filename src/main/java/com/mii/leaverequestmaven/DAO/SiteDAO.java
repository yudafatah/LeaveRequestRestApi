/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.leaverequestmaven.DAO;

import com.mii.leaverequestmaven.model.Employee;
import com.mii.leaverequestmaven.model.Site;
import com.mii.leaverequestmaven.repository.EmployeeRepository;
import com.mii.leaverequestmaven.repository.SiteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yudafatah
 */
@Service
public class SiteDAO {
    @Autowired
    SiteRepository sr;

    public Site save(Site site) {
        return sr.save(site);
    }

    public List<Site> findAll() {
        return sr.findAll();
    }

    public Site findOne(Integer id) {
        return sr.findOne(id);
    }

    public void delete(Site site) {
        sr.delete(site);
    }
}
