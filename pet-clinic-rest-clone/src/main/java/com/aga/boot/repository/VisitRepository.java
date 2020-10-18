package com.aga.boot.repository;

import com.aga.boot.model.Visit;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

public interface VisitRepository {

    Collection<Visit> findByPetId(Integer petId) throws DataAccessException;
    Visit findById(int id) throws DataAccessException;
    Collection<Visit> findAll() throws DataAccessException;
    void save(Visit visit) throws DataAccessException;
    void delete(Visit visit) throws DataAccessException;
}
