package bg.softuni.sportsapptraining.controller;

import bg.softuni.sportsapptraining.model.Comment;
import bg.softuni.sportsapptraining.model.Discipline;
import bg.softuni.sportsapptraining.model.dto.AthleticsDto;
import bg.softuni.sportsapptraining.service.AthleticsService;
import bg.softuni.sportsapptraining.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class AthleticController {


    private final AthleticsService athleticsService;
    private final CommentService commentService;

    public AthleticController(AthleticsService athleticsService, CommentService commentService) {
        this.athleticsService = athleticsService;
        this.commentService = commentService;
    }

    @GetMapping("/athletics")
    public String athletics(Model model){
        model.addAttribute("disciplines", athleticsService.getAllDisciplines());

        return "athletics";
    }

@PostMapping("/athletics")
public String getAthletics(@RequestParam("discipline") String discipline, Model model, Principal principal) {
    Discipline selectedDiscipline = athleticsService.getDisciplineByName(discipline);
    List<Comment> comments = commentService.findByDiscipline(selectedDiscipline);

    String championImageUrl = getChampionImageUrl(discipline);

    model.addAttribute("selectedDiscipline", selectedDiscipline);
    model.addAttribute("disciplines", athleticsService.getAllDisciplines());
    model.addAttribute("championImageUrl", championImageUrl);
    model.addAttribute("comments", comments);
    model.addAttribute("isAuthenticated", principal != null);
    return "athletics";
}

    private String getChampionImageUrl(String discipline) {
        return switch (discipline) {
            case "100 metres" -> "http://res.cloudinary.com/dccqkyfpt/image/upload/v1741093942/suiya5avwujwytzjhwhg.jpg";
            case "200 metres" -> "http://res.cloudinary.com/dccqkyfpt/image/upload/v1741093975/m3dg3cubn6svejxcxaj1.jpg";
            default -> "http://res.cloudinary.com/dccqkyfpt/image/upload/v1741093975/m3dg3cubn6svejxcxaj1.jpg";
        };
    }
}
