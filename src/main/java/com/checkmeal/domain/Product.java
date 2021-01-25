package com.checkmeal.domain;

import com.checkmeal.datacreator.Constants;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @Size(max = Constants.NAME_SIZE)
    @Getter
    @Setter
    private String name;

    @Column
    @Getter
    @Setter
    private String imagePath;

    @Column
    @Getter
    @Setter
    private Double price;

    @Column
    @Getter
    @Setter
    private Boolean active;

    public Product() {
    }

    ;

    public Product(String name, String imagePath, Double price, Boolean active) {
        this.name = name;
        this.imagePath = imagePath;
        this.price = price;
        this.active = active;
    }
}
