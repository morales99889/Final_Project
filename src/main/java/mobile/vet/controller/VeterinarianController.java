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

import mobile.vet.model.Veterinarian;
import mobile.vet.service.VeterinarianService;

import java.util.List;

@RestController
@RequestMapping("/veterinarians")
public class VeterinarianController {
    private final VeterinarianService veterinarianService;

    @Autowired
    public VeterinarianController(VeterinarianService veterinarianService) {
        this.veterinarianService = veterinarianService;
    }

    @GetMapping
    public List<Veterinarian> getAllVeterinarians() {
        return veterinarianService.getAllVeterinarians();
    }

    @GetMapping("/{veterinarianId}")
    public Veterinarian getVeterinarianById(@PathVariable Long veterinarianId) {
        return veterinarianService.getVeterinarianById(veterinarianId);
    }

    @PostMapping
    public Veterinarian createVeterinarian(@RequestBody Veterinarian veterinarian) {
        return veterinarianService.createVeterinarian(veterinarian);
    }

    @PutMapping("/{veterinarianId}")
    public Veterinarian updateVeterinarian(@PathVariable Long veterinarianId, @RequestBody Veterinarian updatedVeterinarian) {
        return veterinarianService.updateVeterinarian(veterinarianId, updatedVeterinarian);
    }

    @DeleteMapping("/{veterinarianId}")
    public ResponseEntity<?> deleteVeterinarian(@PathVariable Long veterinarianId) {
        veterinarianService.deleteVeterinarian(veterinarianId);
        return ResponseEntity.ok().build();
    }
}
