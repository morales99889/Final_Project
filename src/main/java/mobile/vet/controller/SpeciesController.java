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

import mobile.vet.model.Species;
import mobile.vet.service.SpeciesService;

import java.util.List;

@RestController
@RequestMapping("/species")
public class SpeciesController {
    private final SpeciesService speciesService;

    @Autowired
    public SpeciesController(SpeciesService speciesService) {
        this.speciesService = speciesService;
    }

    @GetMapping
    public List<Species> getAllSpecies() {
        return speciesService.getAllSpecies();
    }

    @GetMapping("/{speciesId}")
    public Species getSpeciesById(@PathVariable Long speciesId) {
        return speciesService.getSpeciesById(speciesId);
    }

    @PostMapping
    public Species createSpecies(@RequestBody Species species) {
        return speciesService.createSpecies(species);
    }

    @PutMapping("/{speciesId}")
    public Species updateSpecies(@PathVariable Long speciesId, @RequestBody Species updatedSpecies) {
        return speciesService.updateSpecies(speciesId, updatedSpecies);
    }

    @DeleteMapping("/{speciesId}")
    public ResponseEntity<?> deleteSpecies(@PathVariable Long speciesId) {
        speciesService.deleteSpecies(speciesId);
        return ResponseEntity.ok().build();
    }
}
