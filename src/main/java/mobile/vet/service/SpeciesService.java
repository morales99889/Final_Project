package mobile.vet.service;

import org.springframework.stereotype.Service;

import mobile.vet.dao.SpeciesDao;
import mobile.vet.exception.NotFoundException;
import mobile.vet.model.Species;

import java.util.List;

@Service
public class SpeciesService {
    private final SpeciesDao speciesDao;


    public SpeciesService(SpeciesDao speciesDao) {
        this.speciesDao = speciesDao;
    }

    public List<Species> getAllSpecies() {
        return speciesDao.findAll();
    }

    public Species getSpeciesById(Long speciesId) {
        return speciesDao.findById(speciesId)
            .orElseThrow(() -> new NotFoundException("Species not found with id: " + speciesId));
    }

    public Species createSpecies(Species species) {
        return getSpeciesById(speciesDao.save(species).getSpeciesId());
    }

    public Species updateSpecies(Long speciesId, Species updatedSpecies) {
        Species existingSpecies = getSpeciesById(speciesId);
        existingSpecies.setSpeciesName(updatedSpecies.getSpeciesName());
        return speciesDao.save(existingSpecies);
    }

    public void deleteSpecies(Long speciesId) {
        Species species = getSpeciesById(speciesId);
        speciesDao.delete(species);
    }
}
