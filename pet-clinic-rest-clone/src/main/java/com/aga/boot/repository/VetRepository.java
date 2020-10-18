package com.aga.boot.repository;

import com.aga.boot.model.Vet;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

public interface VetRepository {

    Collection<Vet> findAll() throws DataAccessException;
    Vet findById(int id)  throws DataAccessException;
    void save(Vet vet) throws DataAccessException;
    void delete(Vet vet) throws DataAccessException;
}
