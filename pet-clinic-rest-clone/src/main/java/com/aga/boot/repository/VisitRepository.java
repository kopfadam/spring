package com.aga.boot.repository;

import com.aga.boot.model.Owner;
import com.aga.boot.model.Visit;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface VisitRepository extends JpaRepository<Visit, Integer> {

    Collection<Visit> findByPetId(Integer petId) throws DataAccessException;
    Visit findById(int id) throws DataAccessException;

}
