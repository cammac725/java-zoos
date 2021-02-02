package local.cammac.javazoos.services;

import local.cammac.javazoos.models.Animal;
import local.cammac.javazoos.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service(value = "animalServices")
public class AnimalServicesImpl implements AnimalServices  {

    @Autowired
    AnimalRepository animalrepos;

    @Override
    public Animal findAnimalById(long animalid) {
        return animalrepos.findById(animalid)
                .orElseThrow(() -> new EntityNotFoundException("Animal id " + animalid + " not found"));
    }
}
