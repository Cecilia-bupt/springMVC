package com.cmic.example.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

public class DtoSelectName {

    @NotNull
    @Pattern(regexp = "[a-z]s*", message = "输入参数不合法")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
