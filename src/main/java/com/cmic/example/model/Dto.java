package com.cmic.example.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Dto {

//    private Long id;

    @NotNull
    @Size(min = 3, max = 10)
    private String name;
//    private BigDecimal salary;
//    private LocalDateTime createdDate;

//    public void SetId(){
//        this.id = id;
//    }
//    public Long GetId(){
//        return id;
//    }

//    public void SetName(){
//        this.name = name;
//    }
//    public String GetName(){
//        return name;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


//    public BigDecimal GetSalary() {
//        return salary;
//    }
//
//    public void SetSalary(BigDecimal salary) {
//        this.salary = salary;
//    }
//
//    public LocalDateTime GetCreatedDate() {
//        return createdDate;
//    }
//
//    public void SetCreatedDate(LocalDateTime createdDate) {
//        this.createdDate = createdDate;
//    }

//    @Override
//    public String toString() {
//        return "Employee{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", salary=" + salary +
//                ", createdDate=" + createdDate +
//                '}';
//    }
}
