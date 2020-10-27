package com.aga.boot.service;

import com.aga.boot.model.*;
import com.aga.boot.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class ClinicServiceImpl implements ClinicService {



    private VisitRepository visitRepository;
    private SpecialtyRepository specialtyRepository;


    @Autowired
    public ClinicServiceImpl(


            VisitRepository visitRepository,
            SpecialtyRepository specialtyRepository

    ) {


        this.visitRepository = visitRepository;
        this.specialtyRepository = specialtyRepository;

    }



    @Override
    public Visit findVisitById(int visitId) throws DataAccessException {
        Visit visit = null;
        try {
            visit = visitRepository.findById(visitId);
        } catch (ObjectRetrievalFailureException | EmptyResultDataAccessException e) {
            return null;
        }
        return visit;
    }

    @Override
    public Collection<Visit> findVisitsByPetId(int petId) {

        return visitRepository.findByPetId(petId);

    }

    @Override
    public Collection<Visit> findAllVisits() throws DataAccessException {
        return visitRepository.findAll();
    }

    @Override
    public void saveVisit(Visit visit) throws DataAccessException {
        visitRepository.save(visit);
    }

    @Override
    public void deleteVisit(Visit visit) throws DataAccessException {
        visitRepository.delete(visit);
    }




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
