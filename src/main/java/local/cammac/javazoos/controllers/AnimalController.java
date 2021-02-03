package local.cammac.javazoos.controllers;

import local.cammac.javazoos.services.AnimalServices;
import local.cammac.javazoos.views.AnimalCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalServices animalServices;

    // http://localhost:2021/animals/count
    @GetMapping(value = "/count", produces = "application/json")
    public ResponseEntity<?> countAnimalCounts() {
        List<AnimalCounts> rtnList = animalServices.countZoosByAnimal();
        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }
}
