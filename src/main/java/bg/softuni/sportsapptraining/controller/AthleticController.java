package bg.softuni.sportsapptraining.controller;


import bg.softuni.sportsapptraining.constant.DisciplineConstants;
import bg.softuni.sportsapptraining.model.Comment;
import bg.softuni.sportsapptraining.model.Discipline;
import bg.softuni.sportsapptraining.service.AthleticsService;
import bg.softuni.sportsapptraining.service.CommentService;
import bg.softuni.sportsapptraining.service.DisciplineService;
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
    private final DisciplineService disciplineService;


    public AthleticController(AthleticsService athleticsService, CommentService commentService, DisciplineService disciplineService) {
        this.athleticsService = athleticsService;
        this.commentService = commentService;
        this.disciplineService = disciplineService;
    }

    @ModelAttribute("isLogged")
    public boolean isLogged(Principal principal) {
        return principal != null;
    }

    @GetMapping("/athletics")
    public String athletics(@RequestParam(name = "disciplineId", required = false) Long disciplineId, Model model) {

        model.addAttribute("disciplines", athleticsService.getAllDisciplines());

        if (disciplineId != null) {
            Discipline selected = disciplineService.getDisciplineById(disciplineId);
            List<Comment> comments = commentService.findByDiscipline(selected);

            model.addAttribute("selectedDiscipline", selected);
            model.addAttribute("comments", comments);
            model.addAttribute("championImageUrl",
                    getChampionImageUrl(selected.getName()));
        }

        return "athletics";
    }

    @PostMapping("/athletics")
    public String selectDiscipline(@RequestParam("discipline") String disciplineName) {
        Discipline selected = athleticsService.getDisciplineByName(disciplineName);
        return "redirect:/athletics?disciplineId=" + selected.getId();
    }
    private String getChampionImageUrl(String discipline) {
        return switch (discipline) {
            case DisciplineConstants.DISCIPLINE_100_METRES ->
                    "http://res.cloudinary.com/dccqkyfpt/image/upload/v1741093942/suiya5avwujwytzjhwhg.jpg";
            case DisciplineConstants.DISCIPLINE_200_METRES ->
                    "http://res.cloudinary.com/dccqkyfpt/image/upload/v1741093975/m3dg3cubn6svejxcxaj1.jpg";
            case DisciplineConstants.DISCIPLINE_400_METRES ->
                    "http://res.cloudinary.com/dccqkyfpt/image/upload/v1743063472/i1hbomubigi0ssaud9va.jpg";
            case DisciplineConstants.DISCIPLINE_800_METRES ->
                    "http://res.cloudinary.com/dccqkyfpt/image/upload/v1743063960/yszfgpng9brwa246gaqy.jpg";
            case DisciplineConstants.DISCIPLINE_1500_METRES ->
                    " http://res.cloudinary.com/dccqkyfpt/image/upload/v1743064213/gkosr9ht8puzssvhtuva.jpg";
            default -> "http://res.cloudinary.com/dccqkyfpt/image/upload/v1741093975/m3dg3cubn6svejxcxaj1.jpg";
        };
    }
}
