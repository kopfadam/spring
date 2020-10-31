package com.aga.boot.service.vet;

import com.aga.boot.model.Vet;
import com.aga.boot.repository.VetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class VetServiceImpl implements VetService{

    @Autowired
    private VetRepository vetRepository;

    @Override
    public Vet findVetById(int id) throws DataAccessException {
        Vet vet = null;
        try {
            vet = vetRepository.findById(id);
        } catch (ObjectRetrievalFailureException | EmptyResultDataAccessException e) {
            return null;
        }
        return vet;
    }

    @Override
    @Cacheable(value = "vets")
    public Collection<Vet> findVets() throws DataAccessException {
        return vetRepository.findAll();
    }

    @Override
    public Collection<Vet> findAllVets() throws DataAccessException {
        return vetRepository.findAll();
    }

    @Override
    public Vet saveVet(Vet vet) throws DataAccessException {
        return vetRepository.save(vet);
    }

    @Override
    public void deleteVet(Vet vet) throws DataAccessException {
        vetRepository.delete(vet);
    }
}
