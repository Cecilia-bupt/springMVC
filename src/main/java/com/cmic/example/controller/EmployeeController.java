package com.cmic.example.controller;


import com.cmic.example.model.Employee;
import com.cmic.example.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

    @RequestMapping(value = "/insert/{name}", method = RequestMethod.GET)
    public @ResponseBody String insertTest(@PathVariable String name) throws SQLException {

        String Name = name;
        EmployeeService employeeService = new EmployeeService();
        Employee employee = employeeService.insertEmployee(Name);
        return "insert";
    }

    @RequestMapping(value ="/delete/{id}", method = RequestMethod.GET)
    public @ResponseBody String deleteTest(@PathVariable String id) throws SQLException{

        EmployeeService employeeService = new EmployeeService();
        employeeService.deleteEmployee(id);
        return "delete";
    }

    @RequestMapping(value = "/update/{id}/{name}", method = RequestMethod.GET)
    public @ResponseBody String updateTest(@PathVariable String id, @PathVariable String name) throws SQLException{
        EmployeeService employeeService = new EmployeeService();
        employeeService.updateEmployee(id, name);
        return "update";
    }

    @RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
    public @ResponseBody String selectTest(@PathVariable String id) throws SQLException{

        EmployeeService employeeService = new EmployeeService();
        return employeeService.selectEmployee(id);
    }


}
