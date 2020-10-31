package com.aga.boot.rest;

import com.aga.boot.model.Specialty;
import com.aga.boot.service.specialty.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("api/specialties")
public class SpecialtyController {

    @Autowired
    private SpecialtyService specialtyService;

    @PostMapping
    public ResponseEntity<Specialty> addSpecialty(@RequestBody @Valid Specialty specialty) {

        if (specialty.getId() != null)
            return ResponseEntity.badRequest().build();

        try {
            Specialty specialtyReturned = specialtyService.saveSpecialty(specialty);
            var location = UriComponentsBuilder.fromUriString("api/specialties/{id}").buildAndExpand(specialtyReturned.getId()).toUri();

            return ResponseEntity.created(location).build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<Collection<Specialty>> getSpecialties() {
        var specialties = specialtyService.findAllSpecialties();

        if (specialties.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(specialties);
    }

    @GetMapping("/{specialtyId}")
    public ResponseEntity<Specialty> getSpecialtyById(@PathVariable int specialtyId) {

        var specialty = specialtyService.findSpecialtyById(specialtyId);

        if (specialty == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(specialty);
    }

    @PutMapping("/{specialtyId}")
    public ResponseEntity<Specialty> updateSpecialty(@PathVariable int specialtyId, @RequestBody Specialty specialty) {

        var currentSpecialty = specialtyService.findSpecialtyById(specialtyId);

        if (currentSpecialty.getId() == null)
            return ResponseEntity.notFound().build();

        currentSpecialty.setName(specialty.getName());

        specialtyService.saveSpecialty(currentSpecialty);

        return ResponseEntity.ok(currentSpecialty);
    }

    @DeleteMapping("/{specialtyId}")
    @Transactional
    public ResponseEntity<Void> deleteSpecialty(@PathVariable int specialtyId) {
        var specialty = specialtyService.findSpecialtyById(specialtyId);
        if (specialty == null)
            return ResponseEntity.notFound().build();

        specialtyService.deleteSpecialty(specialty);

        return ResponseEntity.noContent().build();
    }

}
