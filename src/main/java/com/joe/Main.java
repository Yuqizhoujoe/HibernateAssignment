package com.joe;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Application app = new Application();

        Scanner in = new Scanner(System.in);
        int res;
        do {
            System.out.println();
            System.out.println("Enter the number to execute the operation: ");
            System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. GetById");
            System.out.println("5. DisplayAll");
            res = in.nextInt();
            if (res == 1) {
                System.out.println("Enter the Name");
                in.nextLine();
                String name = in.nextLine();
                System.out.println("Enter the Major");
                String major = in.nextLine();
                System.out.println("Enter the School");
                String school = in.nextLine();
                app.insertStudent(name, major, school);
            } else if (res == 2) {
                System.out.println("Enter the student ID: ");
                long id = in.nextLong();
                System.out.println("Which one you want to change? Name(n), Major(m), or School(s)? ");
                String option = in.nextLine();
                if (option == "name" || option == "Name" || option == "n" || option == "NAME") {
                    System.out.println("Enter the New Name: ");
                    String newName = in.nextLine();
                    Student student = app.find(id);
                    student.setName(newName);
                    app.update(student);
                } else if (option == "major" || option == "Major" || option == "m" || option == "MAJOR") {
                    System.out.println("Enter the New Major: ");
                    String newMajor = in.nextLine();
                    Student student = app.find(id);
                    student.setName(newMajor);
                    app.update(student);
                } else if (option == "school" || option == "School" || option == "s" || option == "SCHOOL") {
                    System.out.println("Enter the New School: ");
                    String newSchool = in.nextLine();
                    Student student = app.find(id);
                    student.setName(newSchool);
                    app.update(student);
                }
            } else if (res == 3) {
                System.out.println("Enter the Student ID: ");
                long id = in.nextLong();
                Student student = app.find(id);
                app.delete(student);
            } else if (res == 4) {
                System.out.println("Enter the Student ID: ");
                long id = in.nextLong();
                app.get(id);
            } else if (res == 5) {
                app.getAllStudents();
            }
        } while (res <= 5 && res >= 1);



        // insert student
        /*app.insertStudent("Yuqi Zhou", "CS", "Fordham");
        app.insertStudent( "Edward", "MBA", "USC");
        app.insertStudent( "Stacy", "EE", "UCLA");
        app.insertStudent( "John", "Finance", "UTD");
        app.insertStudent( "Kuang", "Accounting", "China");*/

        // insert
//        app.insertStudent("DamnJoeJoe", "DATA", "NYU");

        // get the student by studentID
//        app.get(7);

        // display all the data
        // app.getAllStudents();

        // update
        /*Student student = app.find(7);
        student.setName("Kevin");
        System.out.println(app.update(student));
        app.get(7);*/

        //
        /*Student student = app.find(8);
        app.delete(student);
        app.getAllStudents();*/
    }

}
