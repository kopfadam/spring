package com.aga.boot.repository.pet;

import com.aga.boot.model.Owner;
import com.aga.boot.model.Pet;
import com.aga.boot.model.PetType;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PetRepository extends JpaRepository<Pet, Integer>, PetCustomRepository {


    Pet findById(int id) throws DataAccessException;

}
