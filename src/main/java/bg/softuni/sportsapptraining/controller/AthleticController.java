package bg.softuni.sportsapptraining.controller;


import bg.softuni.sportsapptraining.model.Comment;
import bg.softuni.sportsapptraining.model.Discipline;
import bg.softuni.sportsapptraining.service.AthleticsService;
import bg.softuni.sportsapptraining.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @ModelAttribute("isLogged")
    public boolean isLogged(Principal principal) {
        return principal != null;
    }


    @GetMapping("/athletics")
    public String athletics(Model model, Principal principal) {
        model.addAttribute("disciplines", athleticsService.getAllDisciplines());
        model.addAttribute("isLogged", principal != null);

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
        model.addAttribute("isLogged", principal != null);

        return "athletics";
    }

    private String getChampionImageUrl(String discipline) {
        return switch (discipline) {
            case "100 metres" ->
                    "http://res.cloudinary.com/dccqkyfpt/image/upload/v1741093942/suiya5avwujwytzjhwhg.jpg";
            case "200 metres" ->
                    "http://res.cloudinary.com/dccqkyfpt/image/upload/v1741093975/m3dg3cubn6svejxcxaj1.jpg";
            case "400 metres" ->
                    "http://res.cloudinary.com/dccqkyfpt/image/upload/v1743063472/i1hbomubigi0ssaud9va.jpg";
            case "800 metres" ->
                    "http://res.cloudinary.com/dccqkyfpt/image/upload/v1743063960/yszfgpng9brwa246gaqy.jpg";
            case "1500 metres" ->
                    " http://res.cloudinary.com/dccqkyfpt/image/upload/v1743064213/gkosr9ht8puzssvhtuva.jpg";
            default -> "http://res.cloudinary.com/dccqkyfpt/image/upload/v1741093975/m3dg3cubn6svejxcxaj1.jpg";
        };
    }
}
