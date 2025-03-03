package bg.softuni.sportsapptraining.controller;

import bg.softuni.sportsapptraining.model.Discipline;
import bg.softuni.sportsapptraining.model.dto.AthleticsDto;
import bg.softuni.sportsapptraining.service.AthleticsService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AthleticController {


    private final AthleticsService athleticsService;

    public AthleticController(AthleticsService athleticsService) {
        this.athleticsService = athleticsService;
    }

    @GetMapping("/athletics")
    public String athletics(Model model){
        model.addAttribute("disciplines", athleticsService.getAllDisciplines());

        return "athletics";
    }

@PostMapping("/athletics")
public String getAthletics(@RequestParam("discipline") String discipline, Model model) {
    Discipline selectedDiscipline = athleticsService.getDisciplineByName(discipline);
    model.addAttribute("selectedDiscipline", selectedDiscipline);
    model.addAttribute("disciplines", athleticsService.getAllDisciplines());
    return "athletics";
}
}
