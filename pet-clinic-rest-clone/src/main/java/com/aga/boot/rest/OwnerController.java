package com.aga.boot.rest;

import com.aga.boot.model.Owner;
import com.aga.boot.service.owner.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;


    @GetMapping("/lastname/{lastName}")
    public ResponseEntity<Collection<Owner>> getOwnersListWithLastName(@PathVariable String lastName){

        var ownersList = ownerService.findOwnerByLastName(lastName);

        if (ownersList.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(ownersList);
    }

    @PostMapping
    public ResponseEntity<Owner> addOwner(@RequestBody @Valid Owner owner){

        if (owner.getId() != null)
            return ResponseEntity.badRequest().build();

        try {
            Owner ownerReturned = ownerService.saveOwner(owner);
            var location = UriComponentsBuilder.fromUriString("api/owners/{id}").buildAndExpand(ownerReturned.getId()).toUri();

            return ResponseEntity.created(location).build();

        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<Collection<Owner>> getOwners(){
        var owners = ownerService.findAllOwners();

        if (owners.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(owners);
    }

    @GetMapping("/{ownerId}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable int ownerId){

        var owner = ownerService.findOwnerById(ownerId);

        if (owner == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(owner);
    }

    @PutMapping("/{ownerId}")
    public ResponseEntity<Owner> updateOwner(@PathVariable int ownerId, @RequestBody Owner owner){

        var currentOwner = ownerService.findOwnerById(ownerId);

        if (currentOwner.getId() == null)
            return ResponseEntity.notFound().build();

        currentOwner.setAddress(owner.getAddress());
        currentOwner.setCity(owner.getCity());
        currentOwner.setFirstName(owner.getFirstName());
        currentOwner.setLastName(owner.getLastName());
        currentOwner.setTelephone(owner.getTelephone());

        ownerService.saveOwner(currentOwner);

        return ResponseEntity.ok(currentOwner);
    }

    @DeleteMapping("/{ownerId}")
    @Transactional
    public ResponseEntity<Void> deleteOwner(@PathVariable int ownerId){
        var owner = ownerService.findOwnerById(ownerId);
        if (owner == null)
            return ResponseEntity.notFound().build();

        ownerService.deleteOwner(owner);

        return ResponseEntity.noContent().build();
    }


}
