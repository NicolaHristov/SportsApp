package bg.softuni.sportsapptraining.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {


    public HomeController() {

    }

    @GetMapping("/")
    public String notLogged(Principal principal) {
        return "index";
    }

    @GetMapping("/home")
    public String loggedIn() {
        return "home";
    }

}

