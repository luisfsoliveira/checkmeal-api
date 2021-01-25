package com.checkmeal.domain;

import com.checkmeal.datacreator.Constants;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Role {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Column
    @Size(max = Constants.NAME_SIZE)
    @NotBlank
    @Getter
    @Setter
    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }
}
