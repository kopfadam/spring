package com.aga.boot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "visits")
@Getter
@Setter
public class Visit extends BaseEntity{

    @Column(name = "visit_date")
    @NotEmpty
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private Date date;

    @Column(name = "description")
    @NotEmpty
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Visit() {
        this.date = new Date();
    }
}
