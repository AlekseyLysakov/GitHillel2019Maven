package com.DataBase;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class DB1 {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException ex) {
            System.out.println("Registration failed");
            return;
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSL=false", "root", "root");) {


            System.out.println("Output of all students:");
            printStudents(connection);
            System.out.println();

            System.out.println("Output of students per group number:");
            printStudentsPerGroup(connection);
            System.out.println();

            System.out.println("Output of students per date:");
            printStudentsPerDate(connection);
            System.out.println();

            System.out.println("Output of lessons with marks and teachers:");
            printLessonsMarksTeachers(connection);
            System.out.println();

            System.out.println("Output of average mark:");
            printAveMark(connection);
            System.out.println();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return;
        }
    }

    private static void printStudents(Connection connection) throws SQLException {
        String query = "select FULL_NAME from student.students";
        try (Statement statement = connection.createStatement();
             ResultSet resSet = statement.executeQuery(query)) {
            while (resSet.next()) {
                String FULL_NAME = resSet.getString("full_name");
                System.out.println(FULL_NAME);
            }
        }
    }

    private static void printStudentsPerGroup(Connection connection) throws SQLException {
        String query = "select FULL_NAME from student.students WHERE GROUP_NUMBER = 23";
        try (Statement statement = connection.createStatement();
             ResultSet resSet = statement.executeQuery(query)) {
            while (resSet.next()) {
                String FULL_NAME = resSet.getString("full_name");
                System.out.println(FULL_NAME);
            }
        }
    }

    private static void printStudentsPerDate(Connection connection) throws SQLException {
        String query = "select FULL_NAME from student.students WHERE YEAR = 1985";
        try (Statement statement = connection.createStatement();
             ResultSet resSet = statement.executeQuery(query)) {
            while (resSet.next()) {
                String FULL_NAME = resSet.getString("full_name");
                System.out.println(FULL_NAME);
            }
        }
    }

    private static void printLessonsMarksTeachers(Connection connection) throws SQLException {
        String query = "select students.FULL_NAME student_name, lessons.NAME_OF_LESSONS, teachers.FULL_NAME teacher_name, marks.MARK\n" +
                "from marks\n" +
                "    left join lessons on marks.LESSON = lessons.ID\n" +
                "    left join students on marks.STUDENT = students.ID\n" +
                "    left join teachers on lessons.TEACHER = teachers.ID";
        try (Statement statement = connection.createStatement();
             ResultSet resSet = statement.executeQuery(query)) {
            while (resSet.next()) {
                String full_name_of_students = resSet.getString("student_name");
                String name_of_lessons = resSet.getString("name_of_lessons");
                String full_name_from_teachers = resSet.getString("teacher_name");
                int mark = resSet.getInt("mark");
                System.out.println(full_name_of_students +" "+ name_of_lessons +" "+ full_name_from_teachers +" "+ mark);
            }
        }
    }


    private static void printAveMark(Connection connection) throws SQLException {
    String query = "SELECT AVG(MARK) AvgMark FROM marks WHERE STUDENT=75";
        try (Statement statement = connection.createStatement();
    ResultSet resSet = statement.executeQuery(query)) {
        while  (resSet.next()) {
            int mark = resSet.getInt("AvgMark");
            System.out.println(mark);
        }
    }
}

}
