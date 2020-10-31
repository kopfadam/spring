package com.aga.boot.service.pet;

import com.aga.boot.model.Pet;
import com.aga.boot.model.PetType;
import com.aga.boot.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class PetServiceImpl implements PetService{

    @Autowired
    private PetRepository petRepository;

    @Override
    public Pet findPetById(int id) throws DataAccessException {
        Pet pet = null;
        try {
            pet = petRepository.findById(id);
        } catch (ObjectRetrievalFailureException | EmptyResultDataAccessException e) {
            return null;
        }
        return pet;
    }

    @Override
    public Collection<Pet> findAllPets() throws DataAccessException {
        return petRepository.findAll();
    }


    @Override
    public Pet savePet(Pet pet) throws DataAccessException {
        return petRepository.save(pet);
    }

    @Override
    public void deletePet(Pet pet) throws DataAccessException {
        petRepository.delete(pet);
    }
}
