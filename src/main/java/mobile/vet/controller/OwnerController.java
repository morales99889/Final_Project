package mobile.vet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mobile.vet.exception.NotFoundException;
import mobile.vet.model.Owner;
import mobile.vet.service.OwnerService;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public List<Owner> getAllOwners() {
        return ownerService.getAllOwners();
    }

    @GetMapping("/{ownerId}")
    public Owner getOwnerById(@PathVariable Long ownerId) throws NotFoundException {
        return ownerService.getOwnerById(ownerId);
    }

    @PostMapping
    public Owner createOwner(@RequestBody Owner owner) {
        return ownerService.createOwner(owner);
    }

    @PutMapping("/{ownerId}")
    public Owner updateOwner(@PathVariable Long ownerId, @RequestBody Owner updatedOwner) {
        try {
            return ownerService.updateOwner(ownerId, updatedOwner);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{ownerId}")
    public ResponseEntity<?> deleteOwner(@PathVariable Long ownerId) throws NotFoundException {
        ownerService.deleteOwner(ownerId);
        return ResponseEntity.ok().build();
    }
}
