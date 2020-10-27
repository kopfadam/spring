package com.aga.boot.service.specialty;

import com.aga.boot.model.Specialty;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

public interface SpecialtyService {
    Specialty findSpecialtyById(int specialtyId);
    Collection<Specialty> findAllSpecialties() throws DataAccessException;
    void saveSpecialty(Specialty specialty) throws DataAccessException;
    void deleteSpecialty(Specialty specialty) throws DataAccessException;
}
