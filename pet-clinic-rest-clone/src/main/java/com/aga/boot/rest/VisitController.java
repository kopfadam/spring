package com.aga.boot.rest;

import com.aga.boot.model.Visit;
import com.aga.boot.service.visit.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("api/visits")
public class VisitController {

    @Autowired
    private VisitService visitService;

    @PostMapping
    public ResponseEntity<Visit> addVisit(@RequestBody @Valid Visit visit) {

        if (visit.getId() != null)
            return ResponseEntity.badRequest().build();

        try {
            Visit visitReturned = visitService.saveVisit(visit);
            var location = UriComponentsBuilder.fromUriString("api/visits/{id}").buildAndExpand(visitReturned.getId()).toUri();

            return ResponseEntity.created(location).build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<Collection<Visit>> getVisits() {
        var visits = visitService.findAllVisits();

        if (visits.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(visits);
    }

    @GetMapping("/pets/{petId}")
    public ResponseEntity<Collection<Visit>> getVisitsOfPet(@PathVariable int petId) {
        var visits = visitService.findVisitsByPetId(petId);

        if (visits.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(visits);
    }

    @GetMapping("/{visitId}")
    public ResponseEntity<Visit> getVisitById(@PathVariable int visitId) {

        var visit = visitService.findVisitById(visitId);

        if (visit == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(visit);
    }

    @PutMapping("/{visitId}")
    public ResponseEntity<Visit> updateVisit(@PathVariable int visitId, @RequestBody Visit visit) {

        var currentVisit = visitService.findVisitById(visitId);

        if (currentVisit.getId() == null)
            return ResponseEntity.notFound().build();

        currentVisit.setDate(visit.getDate());
        currentVisit.setDescription(visit.getDescription());
        currentVisit.setPet(visit.getPet());

        visitService.saveVisit(currentVisit);

        return ResponseEntity.ok(currentVisit);
    }

    @DeleteMapping("/{visitId}")
    @Transactional
    public ResponseEntity<Void> deleteVisit(@PathVariable int visitId) {
        var visit = visitService.findVisitById(visitId);
        if (visit == null)
            return ResponseEntity.notFound().build();

        visitService.deleteVisit(visit);

        return ResponseEntity.noContent().build();
    }
}
