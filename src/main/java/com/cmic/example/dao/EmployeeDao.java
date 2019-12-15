package com.cmic.example.dao;

import com.cmic.example.model.Employee;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class EmployeeDao {
    //Employee employee = new Employee();

    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    //private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";
    //private static final String SQL_DELETE = "delete * from employee where id = ? ";

    public void EmployeeDaoTest(Employee employee) throws SQLException {
//        Long id = employee.getId();
//        String name = employee.getName();
//        BigDecimal salary = employee.getSalary();
//        LocalDateTime createdDate = employee.getCreatedDate();

        String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";

        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=GMT%2B8", "root", "mysql123");
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT);
            conn.setAutoCommit(false);

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setBigDecimal(2,employee.getSalary());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(employee.getCreatedDate()));
            //preparedStatement.
            preparedStatement.addBatch();
            int row = preparedStatement.executeUpdate();
            // rows affected
            System.out.println(row); //

            conn.commit();
        } catch (
                SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void EmployeeDaoDelete(String id) throws SQLException {
        String SQL_DELETE = "delete from employee where id = ? ";
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=GMT%2B8", "root", "mysql123");
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_DELETE);
            preparedStatement.setString(1, id);
            //preparedStatement.
            preparedStatement.addBatch();
            int row = preparedStatement.executeUpdate();
            // rows affected
            System.out.println(row); //
        } catch (
                SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void EmployeeDaoUpdate(String id, String name) throws SQLException {
        String SQL_UPDATE = "update employee set NAME = ? where ID = ?";
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=GMT%2B8", "root", "mysql123");
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, id);
            //preparedStatement.
            preparedStatement.addBatch();
            int row = preparedStatement.executeUpdate();
            // rows affected
            System.out.println(row); //
        } catch (
                SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Employee> EmployeeDaoSelect(String id) {

        ArrayList<Employee> employeeList = new ArrayList<>();
        String SQL_SELECT = "select * from employee where ID < ?";


        // int selid = ID.intValue();
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=GMT%2B8", "root", "mysql123");
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT);
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            conn.setAutoCommit(false);

            while (rs.next()) {
                Employee emp = new Employee();
                emp.setId(rs.getLong("ID"));
                emp.setName(rs.getString("NAME"));
                emp.setSalary(rs.getBigDecimal("SALARY"));
                //emp.setCreatedDate(rs.getTimestamp("CREATED_DATE"));
                emp.setCreatedDate(rs.getTimestamp("CREATED_DATE").toLocalDateTime());
                //System.out.println(id1 + "\t\t" + name +"\t\t" + salary + "\t\t" + );
                employeeList.add(emp);
            }
            rs.close();
            conn.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public ArrayList<Employee> EmployeeDaoSelectName(String name) {

        ArrayList<Employee> employeeList = new ArrayList<>();
        String SQL_SELECT = "select * from employee where Name =  ?";


        // int selid = ID.intValue();
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=GMT%2B8", "root", "mysql123");
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT);
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            conn.setAutoCommit(false);

            while (rs.next()) {
                Employee emp = new Employee();
                emp.setId(rs.getLong("ID"));
                emp.setName(rs.getString("NAME"));
                emp.setSalary(rs.getBigDecimal("SALARY"));
                //emp.setCreatedDate(rs.getTimestamp("CREATED_DATE"));
                emp.setCreatedDate(rs.getTimestamp("CREATED_DATE").toLocalDateTime());
                //System.out.println(id1 + "\t\t" + name +"\t\t" + salary + "\t\t" + );
                employeeList.add(emp);
            }
            rs.close();
            conn.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}


