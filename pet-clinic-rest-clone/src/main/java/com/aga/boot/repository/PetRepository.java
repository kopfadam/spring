package com.aga.boot.repository;

import com.aga.boot.model.Pet;
import com.aga.boot.model.PetType;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;


public interface PetRepository extends JpaRepository<Pet, Integer> {

    Pet findById(int id) throws DataAccessException;

    @Query("SELECT DISTINCT p.type from Pet p ORDER BY p.type.name")
    Collection<PetType> findPetTypesInRecordedPets() throws DataAccessException;

}
