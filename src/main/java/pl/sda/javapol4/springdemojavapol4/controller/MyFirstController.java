package pl.sda.javapol4.springdemojavapol4.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/first-controller")
public class MyFirstController {

    @GetMapping("/home-page")
    public String myHomePage() {
        log.info("inside home page");
        return "index";
    }

    @PostMapping("/post")
    public String post() {
        return "post";
    }
}
