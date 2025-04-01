package bg.softuni.sportsapptraining.controller;

import bg.softuni.sportsapptraining.service.SwimmingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwimmingController {


    private final SwimmingService swimmingService;

    public SwimmingController(SwimmingService swimmingService) {
        this.swimmingService = swimmingService;
    }

    @GetMapping("/swimming")
    public String swimming(Model model){
        model.addAttribute("disciplines", swimmingService.getAllDisciplines());
        return "swimming";
    }
}
