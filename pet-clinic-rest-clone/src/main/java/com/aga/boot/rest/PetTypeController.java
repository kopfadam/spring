package com.aga.boot.rest;

import com.aga.boot.model.PetType;
import com.aga.boot.service.pettype.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/api/pettypes")
public class PetTypeController {

    @Autowired
    private PetTypeService petTypeService;

    @GetMapping
    public ResponseEntity<Collection<PetType>> getAllPetTypes(){
        var petTypes = petTypeService.findAllPetTypes();

        if (petTypes.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(petTypes);
    }

    @GetMapping("/{petTypeId}")
    public ResponseEntity<PetType> getPetType(@PathVariable int petTypeId){
        var petType = petTypeService.findPetTypeById(petTypeId);

        if (petType == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(petType);
    }

    @PostMapping()
    public ResponseEntity<PetType> addPetType(@RequestBody @Valid PetType petType){

        if (petType == null)
            return ResponseEntity.badRequest().build();

        var petTypeCurrent = petTypeService.savePetType(petType);
        var location = UriComponentsBuilder.fromUriString("api/pettypes/{id}").buildAndExpand(petTypeCurrent.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/{petTypeId}")
    public ResponseEntity<PetType> updatePetType(@PathVariable int petTypeId, @RequestBody @Valid PetType petType){

        var currentPetType = petTypeService.findPetTypeById(petTypeId);

        if (currentPetType.getId() == null)
            return ResponseEntity.notFound().build();

        currentPetType.setName(petType.getName());
        petTypeService.savePetType(currentPetType);

        return ResponseEntity.ok(currentPetType);
    }

    @DeleteMapping({"/{petTypeId}"})
    @Transactional
    public ResponseEntity<Void> deletePetType(@PathVariable int petTypeId){

        var petType = petTypeService.findPetTypeById(petTypeId);

        if (petType == null)
            return ResponseEntity.notFound().build();

        petTypeService.deletePetType(petType);

        return ResponseEntity.noContent().build();

    }
}
