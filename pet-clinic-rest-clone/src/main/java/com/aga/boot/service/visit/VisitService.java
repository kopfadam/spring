package com.aga.boot.service.visit;

import com.aga.boot.model.Visit;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

public interface VisitService {

    Visit findVisitById(int visitId) throws DataAccessException;
    Collection<Visit> findVisitsByPetId(int petId);
    Collection<Visit> findAllVisits() throws DataAccessException;
    Visit saveVisit(Visit visit) throws DataAccessException;
    void deleteVisit(Visit visit) throws DataAccessException;
}
