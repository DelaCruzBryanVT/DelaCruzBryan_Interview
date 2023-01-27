package com.codeteam.CrudCode.Model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "department")

public class Department {
    @Id
    @Column(name = "DEP_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int depId;
    @Column(name = "ENT_ID")
    private int entId;
    @Column(name = "DEP_CREATED_BY")
    private String depCreatedBy;
    @Column(name = "DEP_CREATED_DATE")
    private Date depCreatedDate;
    @Column(name = "DEP_MODIFIED_BY")
    private String depModifiedBy;
    @Column(name = "DEP_MODIFIED_DATE")
    private Date depModifiedDate;
    @Column(name = "DEP_STATUS")
    private boolean depStatus;
    @Column(name = "DEP_DESCRIPTION")
    private String depDescription;
    @Column(name = "DEP_NAME")
    private String depName;
    @Column(name = "DEP_PHONE")
    private String depPhone;

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public int getEntId() {
        return entId;
    }

    public void setEntId(int entId) {
        this.entId = entId;
    }

    public String getDepCreatedBy() {
        return depCreatedBy;
    }

    public void setDepCreatedBy(String depCreatedBy) {
        this.depCreatedBy = depCreatedBy;
    }

    public Date getDepCreatedDate() {
        return depCreatedDate;
    }

    public void setDepCreatedDate(Date depCreatedDate) {
        this.depCreatedDate = depCreatedDate;
    }

    public String getDepModifiedBy() {
        return depModifiedBy;
    }

    public void setDepModifiedBy(String depModifiedBy) {
        this.depModifiedBy = depModifiedBy;
    }

    public Date getDepModifiedDate() {
        return depModifiedDate;
    }

    public void setDepModifiedDate(Date depModifiedDate) {
        this.depModifiedDate = depModifiedDate;
    }

    public boolean isDepStatus() {
        return depStatus;
    }

    public void setDepStatus(boolean depStatus) {
        this.depStatus = depStatus;
    }

    public String getDepDescription() {
        return depDescription;
    }

    public void setDepDescription(String depDescription) {
        this.depDescription = depDescription;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDepPhone() {
        return depPhone;
    }

    public void setDepPhone(String depPhone) {
        this.depPhone = depPhone;
    }

}
