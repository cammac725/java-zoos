package local.cammac.javazoos.controllers;

import local.cammac.javazoos.models.Zoo;
import local.cammac.javazoos.services.ZooServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/zoos")
public class ZooController {

    @Autowired
    private ZooServices zooServices;

    // GET http://localhost:2021/zoos/zoos
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
    @PostMapping(value = "/zoo",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<?> addNewZoo(
            @Valid
            @RequestBody Zoo newzoo) throws URISyntaxException {
        newzoo.setZooid(0);
        newzoo = zooServices.save(newzoo);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newZooURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{zooid}")
                .buildAndExpand(newzoo.getZooid())
                .toUri();
        responseHeaders.setLocation(newZooURI);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    // PUT http://localhost:2021/zoos/zoo/5
    @PutMapping(value = "/zoo/{zooid}", consumes = "application/json")
    public ResponseEntity<?> updateFullZoo(
            @Valid
            @RequestBody Zoo updateZoo,
            @PathVariable long zooid) {
        updateZoo.setZooid(zooid);
        zooServices.save(updateZoo);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // PATCH http://localhost:2021/zoos/zoo/4
    @PatchMapping(value = "/zoo/{zooid}", consumes = "appication/json")
    public ResponseEntity<?> updateZoo(
            @RequestBody Zoo updateZoo,
            @PathVariable long zooid) {
        zooServices.update(updateZoo, zooid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // DELETE http://localhost:2021/zoos/zoo/5

}
