package com.aga.boot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "visits", indexes = @Index(name = "UK__DATE_TIME_PET", columnList = "visit_date, pet_id", unique = true))
@Getter
@Setter
public class Visit extends BaseEntity{

    @Column(name = "visit_date")
    @NotNull
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date date;


    @Column(name = "description")
    @NotEmpty
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    /*public Visit() {
        this.dateTime = LocalDateTime.now();
    }*/
}
