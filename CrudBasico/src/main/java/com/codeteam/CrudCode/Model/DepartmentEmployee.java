package com.codeteam.CrudCode.Model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "department_employee")

public class DepartmentEmployee {

    @Id
    @Column(name = "DEP_EMP_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int depEmpId;
    @Column(name = "DEP_ID")
    private int depId;
     @Column(name = "EMP_ID")
    private int empId;
    @Column(name = "DEP_EMP_CREATED_BY")
    private String depEmpCreatedBy;
    @Column(name = "DEP_EMP_CREATED_DATE")
    private Date depEmpCreatedDate;
    @Column(name = "DEP_EMP_MODIFIED_BY")
    private String depEmpModifiedBy;
    @Column(name = "DEP_EMP_MODIFIED_DATE")
    private Date depEmpModifiedDate;
    @Column(name = "DEP_EMP_STATUS")
    private boolean depEmpStatus;

    public int getDepEmpId() {
        return depEmpId;
    }

    public void setDepEmpId(int depEmpId) {
        this.depEmpId = depEmpId;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getDepEmpCreatedBy() {
        return depEmpCreatedBy;
    }

    public void setDepEmpCreatedBy(String depEmpCreatedBy) {
        this.depEmpCreatedBy = depEmpCreatedBy;
    }

    public Date getDepEmpCreatedDate() {
        return depEmpCreatedDate;
    }

    public void setDepEmpCreatedDate(Date depEmpCreatedDate) {
        this.depEmpCreatedDate = depEmpCreatedDate;
    }

    public String getDepEmpModifiedBy() {
        return depEmpModifiedBy;
    }

    public void setDepEmpModifiedBy(String depEmpModifiedBy) {
        this.depEmpModifiedBy = depEmpModifiedBy;
    }

    public Date getDepEmpModifiedDate() {
        return depEmpModifiedDate;
    }

    public void setDepEmpModifiedDate(Date depEmpModifiedDate) {
        this.depEmpModifiedDate = depEmpModifiedDate;
    }

    public boolean isDepEmpStatus() {
        return depEmpStatus;
    }

    public void setDepEmpStatus(boolean depEmpStatus) {
        this.depEmpStatus = depEmpStatus;
    }
   
}
