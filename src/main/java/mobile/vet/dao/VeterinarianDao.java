package mobile.vet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mobile.vet.model.Veterinarian;

public interface VeterinarianDao extends JpaRepository<Veterinarian, Long> {
}