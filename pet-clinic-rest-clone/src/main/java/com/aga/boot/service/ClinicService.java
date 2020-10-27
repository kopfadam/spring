package com.aga.boot.service;

import com.aga.boot.model.*;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

public interface ClinicService {

    Visit findVisitById(int visitId) throws DataAccessException;
    Collection<Visit> findVisitsByPetId(int petId);
    Collection<Visit> findAllVisits() throws DataAccessException;
    void saveVisit(Visit visit) throws DataAccessException;
    void deleteVisit(Visit visit) throws DataAccessException;



    Specialty findSpecialtyById(int specialtyId);
    Collection<Specialty> findAllSpecialties() throws DataAccessException;
    void saveSpecialty(Specialty specialty) throws DataAccessException;
    void deleteSpecialty(Specialty specialty) throws DataAccessException;

}
