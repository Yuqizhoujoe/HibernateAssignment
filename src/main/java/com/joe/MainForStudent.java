package com.joe;

public class MainForStudent {

    /*// Student
        Application app = new Application();

        Scanner in = new Scanner(System.in);
        int res;
        do {
            System.out.println();
            System.out.println("Enter the number to execute the operation: ");
            System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. GetRecordsByID");
            System.out.println("5. DisplayAllRecords");
            System.out.println("6. Exit");
            res = in.nextInt();
            if (res == 1) {
                System.out.println("Enter the Name");
                String name = in.next();
                System.out.println("Enter the Major");
                String major = in.next();
                System.out.println("Enter the School");
                String school = in.next();
                app.insertStudent(name, major, school);
            } else if (res == 2) {
                System.out.println("Enter the student ID: ");
                long id = in.nextLong();
                System.out.println("Which one you want to change? Name(n), Major(m), or School(s)? ");
                String option = in.next();
                if (option == "name" || option == "Name" || option == "n" || option == "NAME") {
                    System.out.println("Enter the New Name: ");
                    String newName = in.next();
                    Student student = app.find(id);
                    student.setName(newName);
                    app.update(student);
                } else if (option == "major" || option == "Major" || option == "m" || option == "MAJOR") {
                    System.out.println("Enter the New Major: ");
                    String newMajor = in.next();
                    Student student = app.find(id);
                    student.setName(newMajor);
                    app.update(student);
                } else if (option == "school" || option == "School" || option == "s" || option == "SCHOOL") {
                    System.out.println("Enter the New School: ");
                    String newSchool = in.next();
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
            } else if (res == 6) {
                app.exit();
            }
        } while (res <= 6 && res >= 1);*/

}
