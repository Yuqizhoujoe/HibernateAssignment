package com.joe;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="department")
public class Department {

    public Department(){

    }

    public Department(String dept){
        this.departmentName = dept;
    }

    public Department(String dept, Set<Employee> employees) {
        this.departmentName = dept;
        this.employees = employees;
    }

    // Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deptId", unique = true, nullable = false)
    private long deptId;
    public long getdeptId() {
        return this.deptId;
    }
    public void setdeptId(long deptId){
        this.deptId = deptId;
    }

    // Department Name
    @Column(name="DepartmentName", unique = true)
    private String departmentName;
    public String getDepartment(){
        return departmentName;
    }
    public void setDepartment(String department){
        this.departmentName = department;
    }

    // relates to Employee Table
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Employee> employees = new HashSet<Employee>(0);
    public Set<Employee> getEmployees(){
        return employees;
    }
    public void addEmployee(Employee employee){
        employees.add(employee);
        employee.setDepartment(this);
    }
    public void removeEmployees(Employee employee) {
        employee.setDepartment(null);
        this.employees.remove(employee);
    }

}
