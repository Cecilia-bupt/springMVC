package com.cmic.example.model;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotNull;

public class DtoTest {

    @NotNull
    @AssertFalse
    private Boolean bool;

    public Boolean getBool() {
        return bool;
    }

    public void setBool(Boolean bool) {
        this.bool = bool;
    }
}
