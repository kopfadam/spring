package com.aga.boot.rest;

import com.aga.boot.model.Specialty;
import com.aga.boot.model.Vet;
import com.aga.boot.service.vet.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("api/vets")
public class VetController {

    @Autowired
        private VetService vetService;

        @PostMapping
        public ResponseEntity<Vet> addVet(@RequestBody @Valid Vet vet){

            if (vet.getId() != null)
                return ResponseEntity.badRequest().build();

            try {
                Vet vetReturned = vetService.saveVet(vet);
                var location = UriComponentsBuilder.fromUriString("api/vets/{id}").buildAndExpand(vetReturned.getId()).toUri();

                return ResponseEntity.created(location).build();

            }catch (Exception e){
                return ResponseEntity.badRequest().build();
            }
        }

        @GetMapping
        public ResponseEntity<Collection<Vet>> getVets(){
            var vets = vetService.findAllVets();

            if (vets.isEmpty())
                return ResponseEntity.notFound().build();

            return ResponseEntity.ok(vets);
        }

        @GetMapping("/{vetId}")
        public ResponseEntity<Vet> getVetById(@PathVariable int vetId){

            var vet = vetService.findVetById(vetId);

            if (vet == null)
                return ResponseEntity.notFound().build();

            return ResponseEntity.ok(vet);
        }

        @PutMapping("/{vetId}")
        public ResponseEntity<Vet> updateVet(@PathVariable int vetId, @RequestBody Vet vet){

            var currentVet = vetService.findVetById(vetId);

            if (currentVet.getId() == null)
                return ResponseEntity.notFound().build();

            currentVet.setFirstName(vet.getFirstName());
            currentVet.setLastName(vet.getLastName());
            currentVet.clearSpecialties();

            for(Specialty spec : vet.getSpecialties()) {
                currentVet.addSpecialty(spec);
            }

            vetService.saveVet(currentVet);

            return ResponseEntity.ok(currentVet);
        }

        @DeleteMapping("/{vetId}")
        @Transactional
        public ResponseEntity<Void> deleteVet(@PathVariable int vetId){
            var vet = vetService.findVetById(vetId);
            if (vet == null)
                return ResponseEntity.notFound().build();

            vetService.deleteVet(vet);

            return ResponseEntity.noContent().build();
        }
}
