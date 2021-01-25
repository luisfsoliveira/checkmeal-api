package com.checkmeal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Dish extends Product {


    @Column
    private Long timePrep;

    public Dish() {
    }

    public Dish(String name, String imagePath, Double price, Boolean active, Long timePrep) {
        super(name, imagePath, price, active);
        this.timePrep = timePrep;
    }

    public Long getTimePrep() {
        return timePrep;
    }

    public void setTimePrep(Long timePrep) {
        this.timePrep = timePrep;
    }
}
