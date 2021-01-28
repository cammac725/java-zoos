package local.cammac.javazoos.repositories;

import local.cammac.javazoos.models.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
}
