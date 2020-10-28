package com.aga.boot.repository;

import com.aga.boot.model.Owner;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {

    Owner findById(int id) throws DataAccessException;
    Collection<Owner> findByLastName(String lastName) throws DataAccessException;
}
