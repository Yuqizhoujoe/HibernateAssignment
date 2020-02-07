package com.joe;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="employee")
@DynamicUpdate
public class Employee {

    public Employee(){

    }

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "empid_generator")
    @SequenceGenerator(name="empid_generator", allocationSize = 1, sequenceName = "empid_seq")
    @Column(name="employeeId")
    private long emplyeeId;

    public long getEmplyeeId() {
        return emplyeeId;
    }

    public void setEmplyeeId(long emplyeeId){
        this.emplyeeId = emplyeeId;
    }

    @Column(name="employName")
    private String employName;

    public String getEmployName(){
        return employName;
    }

    public void setEmployName(String employName){
        this.employName = employName;
    }

    @Column(name="employSalary")
    private double employSalary;

    public double getEmploySalary(){
        return employSalary;
    }

    public void setEmploySalary(double employSalary){
        this.employSalary = employSalary;
    }


}
