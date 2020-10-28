package com.aga.boot.rest;

import com.aga.boot.model.Owner;
import com.aga.boot.service.owner.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<Owner> addOwner(@PathVariable Owner owner){

        if (owner.getId() != null)
            return ResponseEntity.badRequest().build();

        try {
            ownerService.saveOwner(owner);
            var location = UriComponentsBuilder.fromUriString("api/owners/{id}").buildAndExpand(owner.getId()).toUri();

            return ResponseEntity.created(location).build();

        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }


}
