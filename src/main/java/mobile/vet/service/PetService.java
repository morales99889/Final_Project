package mobile.vet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mobile.vet.dao.OwnerDao;
import mobile.vet.dao.PetDao;
import mobile.vet.exception.NotFoundException;
import mobile.vet.model.Pet;

import java.util.List;

@Service
public class PetService {
    private final PetDao petDao;

    @Autowired
    public PetService(PetDao petDao) {
        this.petDao = petDao;
    }

    public List<Pet> getAllPets() {
        return petDao.findAll();
    }

    public Pet getPetById(Long petId) {
        return petDao.findById(petId)
            .orElseThrow(() -> new NotFoundException("Pet not found with id: " + petId));
    }

    public Pet createPet(Pet pet) {
        Pet created = petDao.save(pet);
        return getPetById(created.getPetId());
    }

    public Pet updatePet(Long petId, Pet updatedPet) {
        Pet existingPet = getPetById(petId);
        existingPet.setOwner(updatedPet.getOwner());
        existingPet.setSpecies(updatedPet.getSpecies());
        existingPet.setPetName(updatedPet.getPetName());
        existingPet.setPetSex(updatedPet.getPetSex());
        existingPet.setPetAge(updatedPet.getPetAge());
        existingPet.setPetWeight(updatedPet.getPetWeight());
        existingPet.setPetNotes(updatedPet.getPetNotes());
        return petDao.save(existingPet);
    }

    public void deletePet(Long petId) {
        Pet pet = getPetById(petId);
        petDao.delete(pet);
    }


}
