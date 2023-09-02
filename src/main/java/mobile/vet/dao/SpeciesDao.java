package mobile.vet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mobile.vet.model.Species;

public interface SpeciesDao extends JpaRepository<Species, Long> {
}
