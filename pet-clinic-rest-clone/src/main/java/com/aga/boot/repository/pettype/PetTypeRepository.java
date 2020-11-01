package com.aga.boot.repository.pettype;

import com.aga.boot.model.PetType;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetTypeRepository extends JpaRepository<PetType, Integer>, PetTypeRepositoryOverride {

    PetType findById(int id) throws DataAccessException;
    void delete(PetType petType) throws DataAccessException;

}
