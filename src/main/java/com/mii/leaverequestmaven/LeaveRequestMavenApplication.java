/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.leaverequestmaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 *
 * @author yudafatah
 */
@SpringBootApplication
@EnableJpaAuditing
public class LeaveRequestMavenApplication {
    public static void main(String[] args){
        SpringApplication.run(LeaveRequestMavenApplication.class, args);
    }
}
