package bg.softuni.sportsapptraining.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AthleticController {


    @GetMapping("/athletics")
    public String athletics(){


        return "athletics";
    }
}
