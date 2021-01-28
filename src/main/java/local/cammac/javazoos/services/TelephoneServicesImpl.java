package local.cammac.javazoos.services;

import local.cammac.javazoos.repositories.TelephoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "telephoneServices")
public class TelephoneServicesImpl implements TelephoneServices{

    @Autowired
    private TelephoneRepository telephoneRepository;

}
