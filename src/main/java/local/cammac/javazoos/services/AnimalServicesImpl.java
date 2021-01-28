package local.cammac.javazoos.services;

import local.cammac.javazoos.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "animalServices")
public class AnimalServicesImpl implements AnimalServices  {

    @Autowired
    AnimalRepository animalrepos;

}
