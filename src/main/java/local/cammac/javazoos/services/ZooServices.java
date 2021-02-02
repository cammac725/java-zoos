package local.cammac.javazoos.services;

import local.cammac.javazoos.models.Zoo;

import java.util.List;

public interface ZooServices {

    List<Zoo> findAll();

    Zoo findZooById(Long zooid);

    Zoo save(Zoo zoo);

    Zoo update(Zoo zoo, long zooid);
}
