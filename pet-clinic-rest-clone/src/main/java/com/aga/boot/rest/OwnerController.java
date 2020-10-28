package com.aga.boot.rest;

import com.aga.boot.model.Owner;
import com.aga.boot.service.owner.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
