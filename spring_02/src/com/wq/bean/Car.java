package com.wq.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component("car")
public class Car {
    private String name;
    private String color;

    public String getName() {
        return name;
    }

   @Value("法拉利")
    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }
    @Value(value="red")
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car [name=" + name + ", color=" + color + "]";
    }

}
