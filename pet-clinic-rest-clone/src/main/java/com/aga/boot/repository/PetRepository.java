package com.aga.boot.repository;

import com.aga.boot.model.Pet;
import com.aga.boot.model.PetType;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

public interface PetRepository {

    Collection<PetType> findPetTypes() throws DataAccessException;
    Pet findById(int id) throws DataAccessException;
    Collection<Pet> findAll() throws DataAccessException;
    void save(Pet pet) throws DataAccessException;
    void delete(Pet pet) throws  DataAccessException;
}
