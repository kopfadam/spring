package com.aga.boot.repository;

import com.aga.boot.model.Owner;
import com.aga.boot.model.Specialty;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface SpecialtyRepository extends JpaRepository<Specialty, Integer> {

    Specialty findById(int id)  throws DataAccessException;

}
