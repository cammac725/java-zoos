package local.cammac.javazoos.services;

import local.cammac.javazoos.models.Zoo;
import local.cammac.javazoos.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "userService")
public class ZooServicesImpl implements ZooServices{

    @Autowired
    private ZooRepository zoorepos;

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
}
