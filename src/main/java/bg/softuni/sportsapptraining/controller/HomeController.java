package bg.softuni.sportsapptraining.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String index(){

        return "index";
    }

    @GetMapping("/")
    public String forDelete(){
        return "index";
    }

    @GetMapping("/")
    public String forDeleteew(){
        return "index";
    }

    @GetMapping("/")
    public String forDeleteew3(){
        return "index";
    }
    @GetMapping("/")
    public String forDeleteew4(){
        return "index";
    }
}
