package com.codeteam.CrudCode.Model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "employee")

public class Employee {

    @Id
    @Column(name = "EMP_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    @Column(name = "EMP_CREATED_BY")
    private String empCreatedBy;
    @Column(name = "EMP_CREATED_DATE")
    private Date empCreatedDate;
    @Column(name = "EMP_MODIFIED_BY")
    private String empModifiedBy;
    @Column(name = "EMP_MODIFIED_DATE")
    private Date empModifiedDate;
    @Column(name = "EMP_STATUS")
    private boolean empStatus;
    @Column(name = "EMP_AGE")
    private Integer empAge;
    @Column(name = "EMP_EMAIL")
    private String empEmail;
    @Column(name = "EMP_NAME")
    private String empName;
    @Column(name = "EMP_POSITION")
    private String empPosition;
    @Column(name = "EMP_SURNAME")
    private String empSurname;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpCreatedBy() {
        return empCreatedBy;
    }

    public void setEmpCreatedBy(String empCreatedBy) {
        this.empCreatedBy = empCreatedBy;
    }

    public Date getEmpCreatedDate() {
        return empCreatedDate;
    }

    public void setEmpCreatedDate(Date empCreatedDate) {
        this.empCreatedDate = empCreatedDate;
    }

    public String getEmpModifiedBy() {
        return empModifiedBy;
    }

    public void setEmpModifiedBy(String empModifiedBy) {
        this.empModifiedBy = empModifiedBy;
    }

    public Date getEmpModifiedDate() {
        return empModifiedDate;
    }

    public void setEmpModifiedDate(Date empModifiedDate) {
        this.empModifiedDate = empModifiedDate;
    }

    public boolean isEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(boolean empStatus) {
        this.empStatus = empStatus;
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpPosition() {
        return empPosition;
    }

    public void setEmpPosition(String empPosition) {
        this.empPosition = empPosition;
    }

    public String getEmpSurname() {
        return empSurname;
    }

    public void setEmpSurname(String empSurname) {
        this.empSurname = empSurname;
    }

}
