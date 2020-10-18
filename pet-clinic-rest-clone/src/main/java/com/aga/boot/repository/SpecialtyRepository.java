package com.aga.boot.repository;

import com.aga.boot.model.Specialty;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

public interface SpecialtyRepository {

    Collection<Specialty> findAll() throws DataAccessException;
    Specialty findById(int id)  throws DataAccessException;
    void save(Specialty specialty) throws DataAccessException;
    void delete(Specialty specialty) throws DataAccessException;
}
