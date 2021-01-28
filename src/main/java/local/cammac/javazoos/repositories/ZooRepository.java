package local.cammac.javazoos.repositories;

import local.cammac.javazoos.models.Zoo;
import org.springframework.data.repository.CrudRepository;

public interface ZooRepository extends CrudRepository<Zoo, Long> {
}
