package pl.sda.javapol4.springdemojavapol4.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.javapol4.springdemojavapol4.entity.CoffeeMachine;
import pl.sda.javapol4.springdemojavapol4.service.CoffeeMachineService;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/rest")
@RestController
public class RestCoffeMachineController {

    private static final Logger log = LoggerFactory.getLogger(RestCoffeMachineController.class);
    private final CoffeeMachineService coffeeMachineService;

    public RestCoffeMachineController(CoffeeMachineService coffeeMachineService) {
        this.coffeeMachineService = coffeeMachineService;
    }
//    @GetMapping("/all-coffee-machines")
    @GetMapping(value = "/coffee-machines",
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<CoffeeMachine> myCoffeeMachines(){
        log.info("rest controller - all coffee machines");
        return coffeeMachineService.giveMeMyCoffeeMachines();
    }

//    /coffee-machines/1
//  /coffee-machines/250
//    /coffee-machines/7
    @GetMapping("/coffee-machines/{id}")
    public CoffeeMachine findCoffeeMachineById(@PathVariable("id") long idik){
      log.info("find coffee machine by id: [{}]", idik);
        return coffeeMachineService.findCoffeeMachneById(idik);
}

//    /coffee-machines/{producer}/model/{name}
    @GetMapping("/coffee-machines/{producer}/model/{name}")
    public CoffeeMachine findByProducerAndModelName(
            @PathVariable String producer, @PathVariable("name") String modelName){
        log.info("find coffee machine by producer: [{}] and model name [{}]",
        producer, modelName);
return null;
    }
@PostMapping("/coffee-machines")
//@ResponseStatus(HttpStatus.CREATED)
//    public CoffeeMachine createCoffeeMachine(@RequestBody CoffeeMachine objectToSave) {
   public ResponseEntity<CoffeeMachine> createCoffeeMachine(@RequestBody CoffeeMachine objectToSave){
        log.info("saving new coffee machine: [{}]", objectToSave);

        var saved = coffeeMachineService.saveCoffeeMachine(objectToSave);
return ResponseEntity.created(URI.create("/rest/coffee-machines/" + saved.getId()))
   .body(saved);
}


    /** - my json
     * *[
     * {
     *     "key": value
     * }
     * ]
     */

/**
 * CRUD
 * Read - GET /coffee-machines - all
 * Read One - GET /coffee-machines/{id} - one
 * Create - POST - /coffee-machines -> 201 + Location header
 * Delete - DELETE /coffee-machines/{id} -> 204
 * Update - PATCH - partial update /coffee-machines/{id}
 * Update - PUT - replace /coffee-machines/{id}
 * Error: -> 404 - not found
 * 401 - autentication
 * 403 - authorization
 */
}
