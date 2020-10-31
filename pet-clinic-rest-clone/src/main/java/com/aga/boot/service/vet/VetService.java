package com.aga.boot.service.vet;

import com.aga.boot.model.Vet;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

public interface VetService {
    Vet findVetById(int id) throws DataAccessException;
    Collection<Vet> findVets() throws DataAccessException;
    Collection<Vet> findAllVets() throws DataAccessException;
    Vet saveVet(Vet vet) throws DataAccessException;
    void deleteVet(Vet vet) throws DataAccessException;
}
