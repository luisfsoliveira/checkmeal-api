package com.checkmeal.domain;

import com.checkmeal.util.Constants;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Size(max = Constants.NAME_SIZE)
    @NotBlank
    @Getter
    @Setter
    private String name;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

}
