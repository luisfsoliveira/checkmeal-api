package com.checkmeal.domain;

import com.checkmeal.datacreator.Constants;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @Column
    @Size(max = Constants.NAME_SIZE)
    @NotBlank
    @Setter
    private @NonNull String firstName;

    @Column
    @Size(max = Constants.NAME_SIZE)
    @NotBlank
    @Getter
    @Setter
    private String lastName;

    @Column
    @NotNull
    @Getter
    @Setter
    private Date startDate;

    @Column
    @Getter
    @Setter
    private Date endDate;

    @Column
    @NotNull
    @Getter
    @Setter
    private Boolean status;

    @OneToOne
    @Getter
    @Setter
    Role employeeRole;

    public Employee() {
    }

    public Employee(String firstName, String lastName, Date startDate, Date endDate, Role employeeRole, Boolean status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employeeRole = employeeRole;
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public Boolean getStatus() {
        return status;
    }
}