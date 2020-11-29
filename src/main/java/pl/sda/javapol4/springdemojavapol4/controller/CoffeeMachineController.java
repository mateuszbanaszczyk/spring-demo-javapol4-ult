package pl.sda.javapol4.springdemojavapol4.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.javapol4.springdemojavapol4.service.CoffeeMachineService;

@Slf4j
@Controller
@RequestMapping("/coffee")
public class CoffeeMachineController {

    public static final String NAME = "name";
    public static final String SURNAME = "name";
    private static final String COFFEE_MACHINES = "coffeeMachines";
    private final CoffeeMachineService coffeeMachineService;


    public CoffeeMachineController(CoffeeMachineService coffeeMachineService) {
        this.coffeeMachineService = coffeeMachineService;
    }

//    user name and surname
//    ?imie=mateusz&nazwisko=banaszczyk
    @GetMapping("/all-coffee-machines")
    public String myCoffeeMachines(Model model, @RequestParam(value ="imie", required = false, defaultValue = "Janek") String name,
                                                @RequestParam(value ="nazwisko", required = false, defaultValue = "Kowalski") String surname){
        log.info("my all coffee machines request");
        log.info("name = [{}], surmane = [{}], name, surname");
//        log.info("name = [${name}], surmane = [${surname}]"); == string interpolation kotlin

        var allCoffeeMachines = coffeeMachineService.giveMeMyCoffeeMachines();
       model.addAttribute(COFFEE_MACHINES, allCoffeeMachines);
       model.addAttribute(NAME, name);
       model.addAttribute(SURNAME, surname);
        return "coffees/my-coffees";
    }
}
