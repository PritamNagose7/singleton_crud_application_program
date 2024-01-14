package com.Start;

import com.POJO.Student;
import com.StudentManage.StudentDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class StudentManagementApp {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {

            System.out.println("Press 1 to Insert Student");
            System.out.println("Press 2 to Delete Student");
            System.out.println("Press 3 to Display All Students");
            System.out.println("Press 4 to Update Student");
            System.out.println("Press 5 to Exit System");

            int choice = Integer.parseInt(br.readLine());

            switch (choice) {
                case 1:
                    insertStudent(br);
                    break;
                case 2:
                    deleteStudent(br);
                    break;
                case 3:
                    displayAllStudents();
                    break;
                case 4:
                    updateStudent(br);
                    break;
                case 5:
                    System.out.println("Thank you for using the application.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    
    
    private static void insertStudent(BufferedReader br) throws IOException {
        System.out.println("Enter user name:");
        String usename = br.readLine();

        System.out.println("Enter user password:");
        String password = br.readLine();

        System.out.println("Enter user phone:");
        String phone = br.readLine();

        System.out.println("Enter user email:");
        String email = br.readLine();

        Student newStudent = new Student(usename, password, phone, email);
        boolean success = StudentDao.insertStudent(newStudent);

        if (success) {
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Something went wrong. Try again.");
        }
    }

    
    
    private static void deleteStudent(BufferedReader br) throws IOException {
        System.out.println("Enter student id to delete:");
        int userId = Integer.parseInt(br.readLine());

        boolean success = StudentDao.deleteStudent(userId);

        if (success) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Something went wrong. Try again.");
        }
    }

    
    
    private static void displayAllStudents() {
    	System.out.println("____________________________________________");
    	System.out.println();
        List<Student> students = StudentDao.getAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("____________________________________________");
        System.out.println();
    }

    
    
    private static void updateStudent(BufferedReader br) throws IOException {
        System.out.println("Enter student id to update:");
        int userId = Integer.parseInt(br.readLine());

        System.out.println("Enter new username:");
        String newUsename = br.readLine();

        System.out.println("Enter new password:");
        String newPassword = br.readLine();

        System.out.println("Enter new phone:");
        String newPhone = br.readLine();

        System.out.println("Enter new email:");
        String newEmail = br.readLine();

        Student newStudent = new Student(newUsename, newPassword, newPhone, newEmail);
        boolean success = StudentDao.updateStudent(userId, newStudent);

        if (success) {
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Something went wrong. Try again.");
        }
    }
}
