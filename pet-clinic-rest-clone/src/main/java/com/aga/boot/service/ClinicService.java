package com.aga.boot.service;

import com.aga.boot.model.*;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

public interface ClinicService {





    Specialty findSpecialtyById(int specialtyId);
    Collection<Specialty> findAllSpecialties() throws DataAccessException;
    void saveSpecialty(Specialty specialty) throws DataAccessException;
    void deleteSpecialty(Specialty specialty) throws DataAccessException;

}
