package com.cmic.example.controller;

import com.cmic.example.model.*;
import com.cmic.example.service.DtoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.validation.Valid;
import java.sql.SQLException;

@Controller
@RequestMapping(value = "/DTO")
public class DtoController {

    //http://localhost:8080/SpringMVC/rest/DTO/insert
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    @ResponseBody public String DtoInsert(@Valid @RequestBody Dto dto) throws SQLException {
        DtoService dtoService = new DtoService();
        Employee employee = dtoService.insertDto(dto.getName());
        System.out.println("传入的参数为：" + dto.getName());
        return "insert";
    }

    //http://localhost:8080/SpringMVC/rest/DTO/select
    @RequestMapping(value = "/select", method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    @ResponseBody public String dtoSelect(@Valid @RequestBody DtoSelect dtoselect) throws SQLException {
        DtoService dtoService =  new DtoService();
        return dtoService.selectDto(String.valueOf(dtoselect.getId()));

    }

    //http://localhost:8080/SpringMVC/rest/DTO/test
    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = {"application/json"}, consumes = {"application/json"})
    @ResponseBody public String dtoTest(@Valid @RequestBody DtoTest dtotest){
        if (!dtotest.getBool())
            return "success";
        else
            return "failure";
    }

    //http://localhost:8080/SpringMVC/rest/DTO/selectName
    @RequestMapping(value = "/selectName", method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    @ResponseBody public String dtoSelect(@Valid @RequestBody DtoSelectName dtoselectname) throws SQLException {
        DtoService dtoService =  new DtoService();
        return dtoService.selectNameDto(dtoselectname.getName());

    }


}
