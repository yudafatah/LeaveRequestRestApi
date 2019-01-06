/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.leaverequestmaven.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author yudafatah
 */
@Entity
@Table(name = "parameter")
@EntityListeners(AuditingEntityListener.class)
public class Parameter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "parameter_id")
    private Integer parameterId;
    @Size(max = 50)
    @Column(name = "parameter_name")
    private String parameterName;
    @Column(name = "parameter_limit")
    private Integer parameterLimit;

    public Parameter() {
    }

    public Parameter(Integer parameterId) {
        this.parameterId = parameterId;
    }

    public Integer getParameterId() {
        return parameterId;
    }

    public void setParameterId(Integer parameterId) {
        this.parameterId = parameterId;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public Integer getParameterLimit() {
        return parameterLimit;
    }

    public void setParameterLimit(Integer parameterLimit) {
        this.parameterLimit = parameterLimit;
    }

    public Parameter(Integer parameterId, String parameterName, Integer parameterLimit) {
        this.parameterId = parameterId;
        this.parameterName = parameterName;
        this.parameterLimit = parameterLimit;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parameterId != null ? parameterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parameter)) {
            return false;
        }
        Parameter other = (Parameter) object;
        if ((this.parameterId == null && other.parameterId != null) || (this.parameterId != null && !this.parameterId.equals(other.parameterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mii.leaverequestmaven.model.Parameter[ parameterId=" + parameterId + " ]";
    }
    
}
