package com.aga.boot.service.pettype;

import com.aga.boot.model.PetType;
import com.aga.boot.repository.PetRepository;
import com.aga.boot.repository.PetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class PetTypeServiceImpl implements PetTypeService{

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetTypeRepository petTypeRepository;


    @Override
    public PetType findPetTypeById(int petTypeId) {
        PetType petType = null;
        try {
            petType = petTypeRepository.findById(petTypeId);
        } catch (ObjectRetrievalFailureException | EmptyResultDataAccessException e) {
            return null;
        }
        return petType;
    }

    @Override
    public Collection<PetType> findAllPetTypes() throws DataAccessException {
        return petTypeRepository.findAll();
    }

    @Override
    public Collection<PetType> findPetTypes() throws DataAccessException {
        return petRepository.findPetType();
    }

    @Override
    public void savePetType(PetType petType) throws DataAccessException {
        petTypeRepository.save(petType);
    }

    @Override
    public void deletePetType(PetType petType) throws DataAccessException {
        petTypeRepository.delete(petType);
    }
}
