package com.StudentManage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.DatabaseConnection.DatabaseConnection;
import com.POJO.Student;

public class StudentDao {

    public static boolean insertStudent(Student student) {
        boolean success = false;
        try {
            Connection con = DatabaseConnection.getConnection();
            String query = "INSERT INTO user(usename, password, phone, email) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, student.getusename());
            pstmt.setString(2, student.getPassword());
            pstmt.setString(3, student.getphone());
            pstmt.setString(4, student.getEmail());

            int rowsAffected = pstmt.executeUpdate();
            success = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    
    
    public static boolean updateStudent(int userId, Student newStudent) {
        boolean success = false;
        try {
            Connection con = DatabaseConnection.getConnection();
            String query = "UPDATE user SET usename=?, password=?, phone=?, email=? WHERE user_id=?";
            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, newStudent.getusename());
            pstmt.setString(2, newStudent.getPassword());
            pstmt.setString(3, newStudent.getphone());
            pstmt.setString(4, newStudent.getEmail());
            pstmt.setInt(5, userId);

            int rowsAffected = pstmt.executeUpdate();
            success = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    
    
    public static boolean deleteStudent(int userId) {
        boolean success = false;
        try {
            Connection con = DatabaseConnection.getConnection();
            String query = "DELETE FROM user WHERE user_id=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, userId);

            int rowsAffected = pstmt.executeUpdate();
            success = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    
    
    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try {
            Connection con = DatabaseConnection.getConnection();
            String query = "SELECT * FROM user";
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);

            while (resultSet.next()) {
                int user_id = resultSet.getInt("user_id");
                String usename = resultSet.getString("usename");
                String password = resultSet.getString("password");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");

                Student student = new Student(user_id, usename, password, phone, email);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
