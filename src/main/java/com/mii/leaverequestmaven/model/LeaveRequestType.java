/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.leaverequestmaven.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author yudafatah
 */
@Entity
@Table(name = "leave_request_type")
@XmlRootElement
@EntityListeners(AuditingEntityListener.class)
public class LeaveRequestType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "type_lr_id")
    private Integer typeLrId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 24)
    @Column(name = "type_name")
    private String typeName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duration_limit")
    private int durationLimit;
    @OneToMany(mappedBy = "typeLrId", fetch = FetchType.LAZY)
    //@JsonManagedReference
    @JsonIgnore
    private List<LeaveRequest> leaveRequestList;

    public LeaveRequestType() {
    }

    public LeaveRequestType(Integer typeLrId) {
        this.typeLrId = typeLrId;
    }

    public LeaveRequestType(Integer typeLrId, String typeName, int durationLimit) {
        this.typeLrId = typeLrId;
        this.typeName = typeName;
        this.durationLimit = durationLimit;
    }

    public Integer getTypeLrId() {
        return typeLrId;
    }

    public void setTypeLrId(Integer typeLrId) {
        this.typeLrId = typeLrId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getDurationLimit() {
        return durationLimit;
    }

    public void setDurationLimit(int durationLimit) {
        this.durationLimit = durationLimit;
    }

    @XmlTransient
    public List<LeaveRequest> getLeaveRequestList() {
        return leaveRequestList;
    }

    public void setLeaveRequestList(List<LeaveRequest> leaveRequestList) {
        this.leaveRequestList = leaveRequestList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeLrId != null ? typeLrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LeaveRequestType)) {
            return false;
        }
        LeaveRequestType other = (LeaveRequestType) object;
        if ((this.typeLrId == null && other.typeLrId != null) || (this.typeLrId != null && !this.typeLrId.equals(other.typeLrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mii.leaverequestmaven.model.LeaveRequestType[ typeLrId=" + typeLrId + " ]";
    }
    
}
