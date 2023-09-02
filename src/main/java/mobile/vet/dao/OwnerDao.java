package mobile.vet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mobile.vet.model.Owner;

public interface OwnerDao extends JpaRepository<Owner, Long> {
}
