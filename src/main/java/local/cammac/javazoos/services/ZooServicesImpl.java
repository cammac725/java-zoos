package local.cammac.javazoos.services;

import local.cammac.javazoos.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class ZooServicesImpl implements ZooServices{

    @Autowired
    private ZooRepository zoorepos;

}
