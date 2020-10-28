package com.aga.boot.service.owner;

import com.aga.boot.model.Owner;
import com.aga.boot.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService{

    @Autowired
    private OwnerRepository ownerRepository;


    @Override
    public Owner findOwnerById(int id) throws DataAccessException {
        Owner owner = null;
        try {
            owner = ownerRepository.findById(id);
        } catch (ObjectRetrievalFailureException | EmptyResultDataAccessException e) {
            return null;
        }
        return owner;
    }

    @Override
    public Collection<Owner> findOwnerByLastName(String lastName) throws DataAccessException {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Collection<Owner> findAllOwners() throws DataAccessException {
        return ownerRepository.findAll();
    }

    @Override
    public Owner saveOwner(Owner owner) throws DataAccessException {
        return ownerRepository.save(owner);
    }

    @Override
    public void deleteOwner(Owner owner) throws DataAccessException {
        ownerRepository.delete(owner);
    }
}
