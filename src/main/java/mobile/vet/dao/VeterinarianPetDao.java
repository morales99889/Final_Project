package mobile.vet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mobile.vet.model.VeterinarianPet;
import mobile.vet.model.VeterinarianPetId;

public interface VeterinarianPetDao extends JpaRepository<VeterinarianPet, VeterinarianPetId> {
}
