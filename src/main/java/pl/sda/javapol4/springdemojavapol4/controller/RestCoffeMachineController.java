package pl.sda.javapol4.springdemojavapol4.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.javapol4.springdemojavapol4.entity.CoffeeMachine;
import pl.sda.javapol4.springdemojavapol4.service.CoffeeMachineService;

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
    @GetMapping(value = "/all-coffee-machines",
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<CoffeeMachine> myCoffeeMachines(){
        log.info("rest controller - all coffee machines");
        return coffeeMachineService.giveMeMyCoffeeMachines();
    }
}
