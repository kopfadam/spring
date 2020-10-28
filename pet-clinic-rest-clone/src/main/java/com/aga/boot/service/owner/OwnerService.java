package com.aga.boot.service.owner;

import com.aga.boot.model.Owner;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

public interface OwnerService {
    Owner findOwnerById(int id) throws DataAccessException;
    Collection<Owner> findOwnerByLastName(String lastName) throws DataAccessException;
    Collection<Owner> findAllOwners() throws DataAccessException;
    Owner saveOwner(Owner owner) throws DataAccessException;
    void deleteOwner(Owner owner) throws DataAccessException;
}
