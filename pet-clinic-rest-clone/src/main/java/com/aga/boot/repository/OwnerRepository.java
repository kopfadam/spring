package com.aga.boot.repository;

import com.aga.boot.model.Owner;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

public interface OwnerRepository {

    Owner findById(int id) throws DataAccessException;
    Collection<Owner> findByLastName(String lastName) throws DataAccessException;
    void save(Owner owner) throws DataAccessException;
    Collection<Owner> findAll() throws DataAccessException;
    void delete(Owner owner) throws DataAccessException;
}
