package mobile.vet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mobile.vet.model.Pet;

public interface PetDao extends JpaRepository<Pet, Long> {
}