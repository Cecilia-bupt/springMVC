package com.cmic.example.model;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class DtoSelect {

    @NotNull
    @DecimalMax(value = "10")
    @DecimalMin(value = "2")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
