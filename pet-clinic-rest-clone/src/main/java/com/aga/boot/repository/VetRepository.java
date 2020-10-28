package com.aga.boot.repository;

import com.aga.boot.model.Owner;
import com.aga.boot.model.Vet;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface VetRepository extends JpaRepository<Vet, Integer> {

    Vet findById(int id)  throws DataAccessException;
}
