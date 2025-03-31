package bg.softuni.sportsapptraining.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwimmingController {


    @GetMapping("/swimming")
    public String athletics(Model model){
//        model.addAttribute("disciplines", athleticsService.getAllDisciplines());

        return "athletics";
    }
}
