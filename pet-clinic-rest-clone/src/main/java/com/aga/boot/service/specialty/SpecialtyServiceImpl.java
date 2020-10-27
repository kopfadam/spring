package com.aga.boot.service.specialty;

import com.aga.boot.model.Specialty;
import com.aga.boot.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class SpecialtyServiceImpl implements SpecialtyService{

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Override
    public Specialty findSpecialtyById(int specialtyId) {
        Specialty specialty = null;
        try {
            specialty = specialtyRepository.findById(specialtyId);
        } catch (ObjectRetrievalFailureException | EmptyResultDataAccessException e) {
            return null;
        }
        return specialty;
    }

    @Override
    public Collection<Specialty> findAllSpecialties() throws DataAccessException {
        return specialtyRepository.findAll();
    }

    @Override
    public void saveSpecialty(Specialty specialty) throws DataAccessException {
        specialtyRepository.save(specialty);
    }

    @Override
    public void deleteSpecialty(Specialty specialty) throws DataAccessException {
        specialtyRepository.delete(specialty);
    }
}
