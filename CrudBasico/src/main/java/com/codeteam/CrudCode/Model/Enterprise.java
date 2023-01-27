package com.codeteam.CrudCode.Model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "enterprise")
public class Enterprise {

    @Id
    @Column(name = "ENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int entId;
    @Column(name = "ENT_CREATED_BY")
    private String entCreatedBy;
    @Column(name = "ENT_CREATED_DATE")
    private Date entCreatedDate;
    @Column(name = "ENT_MODIFIED_BY")
    private String entModifiedBy;
    @Column(name = "ENT_MODIFIED_DATE")
    private Date entModifiedDate;
    @Column(name = "ENT_STATUS")
    private boolean entStatus;
    @Column(name = "ENT_ADDRESS")
    private String entAddress;
    @Column(name = "ENT_NAME")
    private String entName;
    @Column(name = "ENT_PHONE")
    private String entPhone;

    public int getEntId() {
        return entId;
    }

    public void setEntId(int entId) {
        this.entId = entId;
    }

    public String getEntCreatedBy() {
        return entCreatedBy;
    }

    public void setEntCreatedBy(String entCreatedBy) {
        this.entCreatedBy = entCreatedBy;
    }

    public Date getEntCreatedDate() {
        return entCreatedDate;
    }

    public void setEntCreatedDate(Date entCreatedDate) {
        this.entCreatedDate = entCreatedDate;
    }

    public String getEntModifiedBy() {
        return entModifiedBy;
    }

    public void setEntModifiedBy(String entModifiedBy) {
        this.entModifiedBy = entModifiedBy;
    }

    public Date getEntModifiedDate() {
        return entModifiedDate;
    }

    public void setEntModifiedDate(Date entModifiedDate) {
        this.entModifiedDate = entModifiedDate;
    }

    public boolean isEntStatus() {
        return entStatus;
    }

    public void setEntStatus(boolean entStatus) {
        this.entStatus = entStatus;
    }

    public String getEntAddress() {
        return entAddress;
    }

    public void setEntAddress(String entAddress) {
        this.entAddress = entAddress;
    }

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }

    public String getEntPhone() {
        return entPhone;
    }

    public void setEntPhone(String entPhone) {
        this.entPhone = entPhone;
    }

}
