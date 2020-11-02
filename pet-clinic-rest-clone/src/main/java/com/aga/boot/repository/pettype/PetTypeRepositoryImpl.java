package com.aga.boot.repository.pettype;

import com.aga.boot.model.Pet;
import com.aga.boot.model.PetType;
import com.aga.boot.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class PetTypeRepositoryImpl implements PetTypeRepositoryOverride{

    @Autowired
    private PetRepository petRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void delete(PetType petType) {
        var pets = petRepository.findPetByPetTypeName(petType.getName());
        petRepository.deleteInBatch(pets);

        entityManager.createQuery("DELETE FROM PetType WHERE id=" + petType.getId()).executeUpdate();
    }
}
