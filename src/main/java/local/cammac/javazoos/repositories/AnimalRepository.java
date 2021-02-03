package local.cammac.javazoos.repositories;

import local.cammac.javazoos.models.Animal;
import local.cammac.javazoos.views.AnimalCounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long> {

    @Query(value = "SELECT a.animaltype, " +
            "     a.animalid, " +
            "     count(za.animalid) as countzoos " +
            "FROM animals a LEFT JOIN zooanimals za " +
            "ON a.animalid = za.animalid " +
            "GROUP BY a.animaltype " +
            "ORDER BY a.animaltype", nativeQuery = true)
    List<AnimalCounts> findZooCounts();
}
