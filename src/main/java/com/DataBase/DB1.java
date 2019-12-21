package com.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB1 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?" + "useSSL=false&user=root&password=root");

        String SQL = "CREATE TABLE STUDENT.COUNTRY(" +
                "id int NOT NULL AUTO_INCREMENT," +
                "NAME varchar(50)," +
                "PRIMARY KEY(id)" +
                ")";

        Statement statement = connection.createStatement();
        statement.execute("SQL");
    }
}
