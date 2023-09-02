package mobile.vet.service;

import org.springframework.stereotype.Service;

import mobile.vet.dao.VeterinarianDao;
import mobile.vet.exception.NotFoundException;
import mobile.vet.model.Veterinarian;

import java.util.List;

@Service
public class VeterinarianService {
    private final VeterinarianDao veterinarianDao;


    public VeterinarianService(VeterinarianDao veterinarianDao) {
        this.veterinarianDao = veterinarianDao;
    }


    public List<Veterinarian> getAllVeterinarians() {
        return veterinarianDao.findAll();
    }

    public Veterinarian getVeterinarianById(Long veterinarianId) {
        return veterinarianDao.findById(veterinarianId)
            .orElseThrow(() -> new NotFoundException("Veterinarian not found with id: " + veterinarianId));
    }

    public Veterinarian createVeterinarian(Veterinarian veterinarian) {
        return getVeterinarianById(veterinarianDao.save(veterinarian).getVeterinarianId());
    }

    public Veterinarian updateVeterinarian(Long veterinarianId, Veterinarian updatedVeterinarian) {
        Veterinarian existingVeterinarian = getVeterinarianById(veterinarianId);
        existingVeterinarian.setFirstName(updatedVeterinarian.getFirstName());
        existingVeterinarian.setLastName(updatedVeterinarian.getLastName());
        return veterinarianDao.save(existingVeterinarian);
    }

    public void deleteVeterinarian(Long veterinarianId) {
        Veterinarian veterinarian = getVeterinarianById(veterinarianId);
        veterinarianDao.delete(veterinarian);
    }
}
