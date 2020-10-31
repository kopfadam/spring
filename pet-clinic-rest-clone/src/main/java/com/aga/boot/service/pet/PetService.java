package com.aga.boot.service.pet;

import com.aga.boot.model.Pet;
import com.aga.boot.model.PetType;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

public interface PetService {

    Pet findPetById(int id) throws DataAccessException;
    Collection<Pet> findAllPets() throws DataAccessException;
    Pet savePet(Pet pet) throws DataAccessException;
    void deletePet(Pet pet) throws DataAccessException;
}
