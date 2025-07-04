package bg.softuni.sportsapptraining.controller;


import bg.softuni.sportsapptraining.constant.DisciplineConstants;
import bg.softuni.sportsapptraining.constant.ImageUrlConstants;
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

import static bg.softuni.sportsapptraining.constant.DisciplineConstants.Athletics.*;
import static bg.softuni.sportsapptraining.constant.ImageUrlConstants.Athletics.*;
import static bg.softuni.sportsapptraining.constant.ImageUrlConstants.Swimming.DEFAULT_URL;

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
            case ATHLETICS_HUNDRED_METRES ->
                    HUNDRED_METRES_URL;
            case ATHLETICS_TWO_HUNDRED_METRES ->
                    TWO_HUNDRED_METRES_URL;
            case ATHLETICS_FOUR_HUNDRED_METRES ->
                   FOUR_HUNDRED_METRES_URL;
            case ATHLETICS_EIGHT_HUNDRED_METRES ->
                    EIGHT_HUNDRED_METRES_URL;
            case ATHLETICS_FIFTEEN_HUNDRED_METRES ->
                    FIFTEEN_HUNDRED_METRES_URL;
            default -> DEFAULT_URL;
        };
    }
}
