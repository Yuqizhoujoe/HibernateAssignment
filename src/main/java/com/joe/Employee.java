package com.joe;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {

    public Employee(){

    }

    public Employee(String employName, double employSalary){
        this.employName = employName;
        this.employSalary = employSalary;
    }

    public Employee(String employName, double employSalary, Department department) {
        this.employName = employName;
        this.employSalary = employSalary;
        this.department = department;
    }

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "empid_generator")
    @SequenceGenerator(name="empid_generator", allocationSize = 1, sequenceName = "empid_seq")
    @Column(name="employeeId")
    private long employeeId;
    public long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(long emplyeeId){
        this.employeeId = employeeId;
    }

    @Column(name="employeeName", unique = true)
    private String employName;
    public String getEmployName(){
        return employName;
    }
    public void setEmployName(String employName){
        this.employName = employName;
    }

    // Employee Salary
    @Column(name="employeeSalary")
    private double employSalary;
    public double getEmploySalary(){
        return employSalary;
    }
    public void setEmploySalary(double employSalary){
        this.employSalary = employSalary;
    }

    // relates to Department table by deptId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="deptId", nullable = false)
    private Department department;
    public Department getDeptment(){
        return this.department;
    }
    public void setDepartment(Department department){
        this.department = department;
    }

}
