package com.github.mykhalechko.productlist.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Category {

    @NotNull
    @Size(min = 4, max = 20)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
