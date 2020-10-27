package com.aga.boot.service.pettype;

import com.aga.boot.model.PetType;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

public interface PetTypeService {

    PetType findPetTypeById(int petTypeId);
    Collection<PetType> findAllPetTypes() throws DataAccessException;
    Collection<PetType> findPetTypes() throws DataAccessException;
    void savePetType(PetType petType) throws DataAccessException;
    void deletePetType(PetType petType) throws DataAccessException;
}
