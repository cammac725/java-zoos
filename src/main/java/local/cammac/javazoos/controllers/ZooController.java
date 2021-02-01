package local.cammac.javazoos.controllers;

import local.cammac.javazoos.models.Zoo;
import local.cammac.javazoos.services.ZooServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zoos")
public class ZooController {

    @Autowired
    private ZooServices zooServices;

    // GET http://localhost:2019/zoos/zoos
    @GetMapping(value = "/zoos", produces = "application/json")
    public ResponseEntity<?> listAllZoos() {
        List<Zoo> zooList = zooServices.findAll();
        return new ResponseEntity<>(zooList, HttpStatus.OK);
    }

    // GET http://localhost:2021/zoos/zoo/{id}
    @GetMapping(value = "/zoo/{zooid}", produces = "application/json")
    public ResponseEntity<?> getZooById(@PathVariable Long zooid) {
        Zoo z = zooServices.findZooById(zooid);
        return new ResponseEntity<>(z, HttpStatus.OK);
    }

    // POST http://localhost:2021/zoos/zoo

    // PUT http://localhost:2021/zoos/zoo/5

    // PATCH http://localhost:2021/zoos/zoo/4

    // DELETE http://localhost:2021/zoos/zoo/5

}
