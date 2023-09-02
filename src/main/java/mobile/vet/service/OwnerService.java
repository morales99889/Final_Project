package mobile.vet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mobile.vet.dao.OwnerDao;
import mobile.vet.exception.NotFoundException;
import mobile.vet.model.Owner;

import java.util.List;

@Service
public class OwnerService {
    private final OwnerDao ownerDao;

    @Autowired
    public OwnerService(OwnerDao ownerDao) {
        this.ownerDao = ownerDao;
    }

    public List<Owner> getAllOwners() {
        return ownerDao.findAll();
    }

    public Owner getOwnerById(Long ownerId) throws NotFoundException {
        return ownerDao.findById(ownerId)
            .orElseThrow(() -> new NotFoundException("Owner not found with id: " + ownerId));
    }

    public Owner createOwner(Owner owner) {
        Owner created = ownerDao.save(owner);
        return getOwnerById(created.getOwnerId());
    }

    public Owner updateOwner(Long ownerId, Owner updatedOwner) throws NotFoundException {
        Owner existingOwner = getOwnerById(ownerId);
        existingOwner.setFirstName(updatedOwner.getFirstName());
        existingOwner.setLastName(updatedOwner.getLastName());
        existingOwner.setEmail(updatedOwner.getEmail());
        existingOwner.setPhone(updatedOwner.getPhone());
        existingOwner.setAddress(updatedOwner.getAddress());

        return ownerDao.save(existingOwner);
    }

    public void deleteOwner(Long ownerId) throws NotFoundException {
        Owner owner = getOwnerById(ownerId);
        ownerDao.delete(owner);
    }
}
