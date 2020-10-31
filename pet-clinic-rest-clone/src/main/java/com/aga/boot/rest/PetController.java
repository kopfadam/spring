package com.aga.boot.rest;

import com.aga.boot.model.Pet;
import com.aga.boot.model.PetType;
import com.aga.boot.service.pet.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("/{petId}")
    public ResponseEntity<Pet> getPet(@PathVariable int petId){
        var pet = petService.findPetById(petId);

        if (pet == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(pet);
    }

    @PostMapping("")
    public ResponseEntity<Pet> addPet(@RequestBody @Valid Pet pet){

        if (pet.getId() != null)
            return ResponseEntity.badRequest().build();
        try {
            var petReturned = petService.savePet(pet);
            var location = UriComponentsBuilder.fromUriString("api/pets/{id}").buildAndExpand(petReturned.getId()).toUri();

            return ResponseEntity.created(location).build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<Collection<Pet>> getPets(){
        var pets = petService.findAllPets();

        if (pets.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(pets);
    }

    @GetMapping("/types")
    public ResponseEntity<Collection<PetType>> getPetTypes(){

        var petTypes = petService.findPetTypes();

        if (petTypes.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(petTypes);
    }

    @PutMapping("/{petId}")
    public ResponseEntity<Pet> updatePet(@PathVariable int petId, @RequestBody @Valid Pet pet){
        var currentPet = petService.findPetById(petId);

        if (currentPet.getId() == null){
            return ResponseEntity.notFound().build();
        }

        currentPet.setBirthDate(pet.getBirthDate());
        currentPet.setOwner(pet.getOwner());
        currentPet.setType(pet.getType());
        currentPet.setName(pet.getName());

        petService.savePet(currentPet);

        return ResponseEntity.ok(currentPet);
    }

    @DeleteMapping("/{petId}")
    @Transactional
    public ResponseEntity<Void> deletePet(@PathVariable int petId){
        var pet = petService.findPetById(petId);

        if (pet == null)
            return ResponseEntity.notFound().build();

        petService.deletePet(pet);

        return ResponseEntity.noContent().build();
    }
}
