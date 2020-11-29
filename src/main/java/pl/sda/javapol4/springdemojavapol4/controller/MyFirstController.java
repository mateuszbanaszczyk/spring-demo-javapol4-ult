package pl.sda.javapol4.springdemojavapol4.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.javapol4.springdemojavapol4.service.MyFirstService;

@Controller
@Slf4j
@RequestMapping("/first-controller")
public class MyFirstController {

//    controller zarzadza requestami, kontroler komunikuje się z serwisem
//    controller tworzy widok razem z template engine - thymeleaf
//    z controlera nazwa widoku
    private static final String DATA = "data"; //data to klucz
    private final MyFirstService myFirstService;

    //    @Autowired
    public MyFirstController(MyFirstService myFirstService) {
        this.myFirstService = myFirstService;
    }


    @GetMapping("/home-page")
    public String myHomePage() {
        log.info("inside home page");
        return "index";
    }

    @PostMapping("/post")
    public String post() {
        return "post";
    }


    @GetMapping("/my-secrets")
    public String showMySecrets(Model model) {
        log.info("showing my secrets...");
//    ....

        String mySecret = myFirstService.giveMeMySecret();
        model.addAttribute(DATA, mySecret); // klucz "data", wartość -> (wkładany sekret); dodaj atrybut DATA do mySecret
        model.addAttribute("name", "Mateusz");
        model.addAttribute("surname", "B.");
        return "my-secrets-page";
    }
}

// MVC pattern
// V - htmls
// C - controller
// M - model: Service and Repository

//View
//Controller
//Service
//Repository