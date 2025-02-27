package bg.softuni.sportsapptraining.controller;

import bg.softuni.sportsapptraining.model.dto.AthleticsDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AthleticController {




    @GetMapping("/athletics")
    public String athletics(){


        return "athletics";
    }

    @PostMapping("/athletics")
    public String getAthletics(@Valid AthleticsDto data, BindingResult bindingResult, RedirectAttributes redirectAttributes){



        return "athletics";
    }
}
