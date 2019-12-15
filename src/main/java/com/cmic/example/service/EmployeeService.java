package com.cmic.example.service;

import com.cmic.example.dao.EmployeeDao;
import com.cmic.example.model.Employee;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

//@Service
public class EmployeeService {


    public Employee insertEmployee(String Name) throws SQLException {
        Employee employee = new Employee();
        BigDecimal salary = new BigDecimal(799.88);
        //BigDecimal salary = Salary;
        LocalDateTime createdDate = LocalDateTime.now();;
        //LocalDateTime createdDate = CreatedBate;
        employee.setName(Name);
        employee.setSalary(salary);
        employee.setCreatedDate(createdDate);
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.EmployeeDaoTest(employee);
        return employee;
    }

    public void deleteEmployee(String id) throws SQLException{
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.EmployeeDaoDelete(id);
    }

    public void updateEmployee(String id, String name) throws SQLException{
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.EmployeeDaoUpdate(id, name);
    }

    public String selectEmployee(String id) throws SQLException{
        EmployeeDao employeeDao = new EmployeeDao();
        ArrayList<Employee> employeeArrayList = employeeDao.EmployeeDaoSelect(id);
        //return employeeArrayList;
        int num = employeeArrayList.size();

        System.out.println(num);
        if (num == 0)
            return "No result";
        else{
            for(int i = 0; i < num; i++){
                Employee em = employeeArrayList.get(i);
                System.out.println(em.getName() + "   " + em.getSalary() + "   " + em.getCreatedDate());
            }
            return "The number of selected result is " + num;
        }

    }
}
