package local.cammac.javazoos.services;

import local.cammac.javazoos.models.Animal;
import local.cammac.javazoos.views.AnimalCounts;

import java.util.List;

public interface AnimalServices {
    Animal findAnimalById(long animalid);

    List<AnimalCounts> countZoosByAnimal();
}
