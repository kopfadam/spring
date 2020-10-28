package com.aga.boot.repository;

import com.aga.boot.model.Owner;
import com.aga.boot.model.PetType;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PetTypeRepository extends JpaRepository<PetType, Integer> {

    PetType findById(int id) throws DataAccessException;

}
