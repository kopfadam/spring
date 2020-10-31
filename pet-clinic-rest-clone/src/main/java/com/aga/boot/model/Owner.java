package com.aga.boot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "owners")
@Getter
@Setter
public class Owner extends Person{
    @Column(name = "address")
    @NotEmpty
    private String address;

    @Column(name = "city")
    @NotEmpty
    private String city;

    @Column(name = "telephone")
    @NotEmpty
    @Size(min = 10, max = 10)
    @Pattern(regexp = "(^[0-9]{10})")
    private String telephone;

}
