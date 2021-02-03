package local.cammac.javazoos.services;

import local.cammac.javazoos.models.Animal;
import local.cammac.javazoos.models.Telephone;
import local.cammac.javazoos.models.Zoo;
import local.cammac.javazoos.models.ZooAnimals;
import local.cammac.javazoos.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "userService")
public class ZooServicesImpl implements ZooServices{

    @Autowired
    private ZooRepository zoorepos;

    @Autowired
    private AnimalServices animalServices;
    @Override
    public List<Zoo> findAll() {
        List<Zoo> list = new ArrayList<>();
        zoorepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Zoo findZooById(Long zooid) throws EntityNotFoundException {
        return zoorepos.findById(zooid)
                .orElseThrow(() -> new EntityNotFoundException("Zoo id " + zooid + " not found."));
    }

    @Transactional
    @Override
    public Zoo save(Zoo zoo) {
        Zoo newZoo = new Zoo();

        if (zoo.getZooid() != 0) {
            findZooById(zoo.getZooid());
            newZoo.setZooid(zoo.getZooid());
        }

        // single value fields
        newZoo.setZooname(zoo.getZooname());

        // collections
        newZoo.getTelephones().clear();
        for (Telephone t : zoo.getTelephones()) {
            Telephone newTelephone = new Telephone(newZoo, t.getPhonenumber(), t.getPhonetype());
            newZoo.getTelephones().add(newTelephone);
        }

        newZoo.getAnimals().clear();
        for (ZooAnimals a : zoo.getAnimals()) {
            Animal newAnimal = animalServices.findAnimalById(a.getAnimal().getAnimalid());

            newZoo.getAnimals().add(new ZooAnimals(newZoo, newAnimal, null));
        }

        return zoorepos.save(newZoo);
    }

    @Transactional
    @Override
    public Zoo update(Zoo zoo, long zooid) {
        Zoo currentZoo = findZooById(zooid);

        if (zoo.getZooname() != null) {
            currentZoo.setZooname(zoo.getZooname().toLowerCase());
        }
        if (zoo.getAnimals().size() > 0) {
            currentZoo.getAnimals().clear();
            for (ZooAnimals a : zoo.getAnimals()) {
                Animal newAnimal = animalServices.findAnimalById(a.getAnimal().getAnimalid());
                currentZoo.getAnimals().add(new ZooAnimals(currentZoo, newAnimal, null));
            }
        }
        if (zoo.getTelephones().size() > 0) {
            currentZoo.getTelephones().clear();
            for (Telephone t : zoo.getTelephones()) {
                currentZoo.getTelephones().add(new Telephone(currentZoo, t.getPhonetype(), t.getPhonenumber()));
            }
        }
        return zoorepos.save(currentZoo);
    }

    @Override
    public void delete(long zooid) {
        Zoo z = findZooById(zooid);
        if (z != null) {
            zoorepos.deleteById(zooid);
        } else {
            throw new EntityNotFoundException("Zoo id " + zooid + " not found");
        }
    }
}
