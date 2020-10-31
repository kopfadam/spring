package com.aga.boot.repository;

import com.aga.boot.model.Pet;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PetRepository extends JpaRepository<Pet, Integer> {

    Pet findById(int id) throws DataAccessException;

}
