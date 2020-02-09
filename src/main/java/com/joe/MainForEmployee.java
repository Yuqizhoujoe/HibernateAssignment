package com.joe;


import java.util.Set;

public class MainForEmployee {

    public static void main(String args[]) {

        // create objects for department application and employee application for update, delete, create and display
        DepartmentApplication da = new DepartmentApplication();
        EmployeeApplication ea = new EmployeeApplication();
        // employee Nami Pirate
        Employee luffy = new Employee();
        luffy.setEmployName("Luffy");
        luffy.setEmploySalary(56);

        // employee Nami Pirate
        Employee Nami = new Employee();
        Nami.setEmployName("Nami");
        Nami.setEmploySalary(60);

        // employee Zoro Pirate
        Employee Zoro = new Employee();
        Zoro.setEmployName("Zoro");
        Zoro.setEmploySalary(80);

        // employee shanks Pirate
        Employee shanks = new Employee();
        shanks.setEmployName("Shanks");
        shanks.setEmploySalary(708);

        // save pirates into pirateList and then add into pirate department
        Department Pirate = new Department("Pirate");

        // employee Naruto ninja
        Employee Naruto = new Employee();
        Naruto.setEmployName("Naruto");
        Naruto.setEmploySalary(45);

        // employee Itachi ninja
        Employee Itachi = new Employee();
        Itachi.setEmployName("Itachi");
        Itachi.setEmploySalary(57);

        // employee Hinata ninja
        Employee Hinata = new Employee();
        Hinata.setEmployName("Hinata");
        Hinata.setEmploySalary(59);

        // save Ninjas into Ninja List and then add into ninja department
        Department Ninja = new Department("Ninja");

        // add employees into pirate department
        Pirate.addEmployee(luffy);
        Pirate.addEmployee(Nami);
        Pirate.addEmployee(Zoro);
        Pirate.addEmployee(shanks);
        da.create(Pirate);

        // add employees into ninja department
        Ninja.addEmployee(Naruto);
        Ninja.addEmployee(Itachi);
        Ninja.addEmployee(Hinata);
        da.create(Ninja);

        da.displayAllDept();
        ea.showAllEmployees();

        // delete dept
        Department departmentToRemove = da.find(2);
        da.delete(departmentToRemove);
        da.displayAllDept();
        // add ninja back
        Department ninja = new Department("Ninja");
        // assign employees to ninja department
        // employee naruto ninja department
        Employee naruto = new Employee();
        naruto.setEmployName("Naruto");
        naruto.setEmploySalary(600);
        // employee hinata ninja dept
        Employee hinata = new Employee();
        hinata.setEmployName("Hinata");
        hinata.setEmploySalary(700);
        // add employees into ninja dept
        ninja.addEmployee(naruto);
        ninja.addEmployee(hinata);
        da.create(ninja);
        da.displayAllDept();

        // update
        // add new employee into the department ninja
        Department addEmployee = da.find(4);
        Employee jiraiya = new Employee();
        jiraiya.setEmployName("Jiraiya");
        jiraiya.setEmploySalary(80);
        addEmployee.addEmployee(jiraiya);
        da.update(addEmployee);

        // change the salary
        // get the department pirate
        Department department1 = da.find(1);
        // create a set to store employees
        Set<Employee> employees1 = department1.getEmployees();
        // get the employee Luffy id 2 and change the salary
        for (Employee employee : employees1) {
            if (employee.getEmployeeId() == 2) {
                employee.setEmploySalary(1000);
            }
        }
        da.update(department1);

        // delete employee
        ea.getById(4);
        Employee employeeToDelete = ea.find(4);
        ea.delete(employeeToDelete);
        da.displayAllDept();
    }

}
