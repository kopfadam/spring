package com.aga.boot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Entity
@Table(name = "visits", indexes = @Index(name = "UK__DATE_TIME_PET", columnList = "visit_date, pet_id", unique = true))
@Getter
@Setter
public class Visit extends BaseEntity{

    @Column(name = "visit_date", updatable = false)
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss a")
    private LocalDateTime date;

    @Column(name = "description")
    @NotEmpty
    private String description;

    @Column(name = "modified")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss a")
    private LocalDateTime modified;

    @ManyToOne
    @JoinColumn(name = "pet_id", updatable = false)
    private Pet pet;

    @PrePersist
    void onCreate(){
        LocalDateTime date = LocalDateTime.now();
        this.date = date;
        this.modified = date;
    }

    @PreUpdate
    void onUpdate(){
        this.modified = LocalDateTime.now();
    }
}
