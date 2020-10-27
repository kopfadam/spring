package com.aga.boot.service;

import com.aga.boot.model.*;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ClinicServiceImpl implements ClinicService{
    @Override
    public Pet findPetById(int id) throws DataAccessException {
        return null;
    }

    @Override
    public Collection<Pet> findAllPets() throws DataAccessException {
        return null;
    }

    @Override
    public void savePet(Pet pet) throws DataAccessException {

    }

    @Override
    public void deletePet(Pet pet) throws DataAccessException {

    }

    @Override
    public Visit findVisitById(int visitId) throws DataAccessException {
        return null;
    }

    @Override
    public Collection<Visit> findVisitsByPetId(int petId) {
        return null;
    }

    @Override
    public Collection<Visit> findAllVisits() throws DataAccessException {
        return null;
    }

    @Override
    public void saveVisit(Visit visit) throws DataAccessException {

    }

    @Override
    public void deleteVisit(Visit visit) throws DataAccessException {

    }

    @Override
    public Vet findVetById(int id) throws DataAccessException {
        return null;
    }

    @Override
    public Collection<Vet> findVets() throws DataAccessException {
        return null;
    }

    @Override
    public Collection<Vet> findAllVets() throws DataAccessException {
        return null;
    }

    @Override
    public void saveVet(Vet vet) throws DataAccessException {

    }

    @Override
    public void deleteVet(Vet vet) throws DataAccessException {

    }

    @Override
    public Owner findOwnerById(int id) throws DataAccessException {
        return null;
    }

    @Override
    public Collection<Owner> findOwnerByLastName(String lastName) throws DataAccessException {
        return null;
    }

    @Override
    public Collection<Owner> findAllOwners() throws DataAccessException {
        return null;
    }

    @Override
    public void saveOwner(Owner owner) throws DataAccessException {

    }

    @Override
    public void deleteOwner(Owner owner) throws DataAccessException {

    }

    @Override
    public PetType findPetTypeById(int petTypeId) {
        return null;
    }

    @Override
    public Collection<PetType> findAllPetTypes() throws DataAccessException {
        return null;
    }

    @Override
    public Collection<PetType> findPetTypes() throws DataAccessException {
        return null;
    }

    @Override
    public void savePetType(PetType petType) throws DataAccessException {

    }

    @Override
    public void deletePetType(PetType petType) throws DataAccessException {

    }

    @Override
    public Specialty findSpecialtyById(int specialtyId) {
        return null;
    }

    @Override
    public Collection<Specialty> findAllSpecialties() throws DataAccessException {
        return null;
    }

    @Override
    public void saveSpecialty(Specialty specialty) throws DataAccessException {

    }

    @Override
    public void deleteSpecialty(Specialty specialty) throws DataAccessException {

    }
}
