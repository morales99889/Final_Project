package mobile.vet.service;

import org.springframework.stereotype.Service;

import mobile.vet.dao.VeterinarianPetDao;
import mobile.vet.exception.NotFoundException;
import mobile.vet.model.VeterinarianPet;

import java.util.List;
import java.util.Objects;

@Service
public class VeterinarianPetService {
    private final VeterinarianPetDao veterinarianPetDao;

    public VeterinarianPetService(VeterinarianPetDao veterinarianPetDao) {
        this.veterinarianPetDao = veterinarianPetDao;
    }

    public VeterinarianPet createVeterinarianPet(VeterinarianPet veterinarianPet) {
        return veterinarianPetDao.save(veterinarianPet);
    }

    public void deleteVeterinarianPet(Long veterinarianId, Long petId) {
        List<VeterinarianPet> all = veterinarianPetDao.findAll();
        VeterinarianPet petDel = null;

        for (VeterinarianPet pet : all) {
            if (Objects.equals(pet.getPet().getPetId(), petId) &&
                Objects.equals(pet.getVeterinarian().getVeterinarianId(), veterinarianId)) {
                petDel = pet;
            }
        }

        if (petDel == null) {
            throw new NotFoundException("Veterinarian Pet not found");
        }

        veterinarianPetDao.delete(petDel);
    }

}

