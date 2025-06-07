package bg.softuni.sportsapptraining.controller;

import bg.softuni.sportsapptraining.constant.DisciplineConstants;
import bg.softuni.sportsapptraining.constant.ImageUrlConstants;
import bg.softuni.sportsapptraining.model.Comment;
import bg.softuni.sportsapptraining.model.Discipline;
import bg.softuni.sportsapptraining.service.CommentService;
import bg.softuni.sportsapptraining.service.SwimmingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

import static bg.softuni.sportsapptraining.constant.DisciplineConstants.Swimming.*;
import static bg.softuni.sportsapptraining.constant.ImageUrlConstants.Swimming.*;

@Controller
@RequestMapping("/swimming")
public class SwimmingController {
    private final SwimmingService swimmingService;
    private final CommentService commentService;

    public SwimmingController(SwimmingService swimmingService, CommentService commentService) {
        this.swimmingService = swimmingService;
        this.commentService = commentService;
    }

    @ModelAttribute("isLogged")
    public boolean isLogged(Principal principal) {
        return principal != null;
    }

    @GetMapping
    public String showSwimming(
            @RequestParam(name = "disciplineId", required = false) Long disciplineId,
            Model model) {

        model.addAttribute("disciplines", swimmingService.getAllDisciplines());

        if (disciplineId != null) {
            Discipline selected = swimmingService.getDisciplineById(disciplineId);
            List<Comment> comments = commentService.findByDiscipline(selected);

            model.addAttribute("selectedDiscipline", selected);
            model.addAttribute("comments", comments);
            model.addAttribute("championImageUrl",
                    getChampionImageUrl(selected.getName()));
        }

        return "swimming";
    }

    @PostMapping
    public String selectDiscipline(@RequestParam("discipline") String disciplineName) {
        Discipline selected = swimmingService.getDisciplineByName(disciplineName);
        return "redirect:/swimming?disciplineId=" + selected.getId();
    }


    private String getChampionImageUrl(String discipline) {
        return switch (discipline) {
            case  SWIMMING_FREESTYLE_50M  -> FREESTYLE_50M_URL;
            case  SWIMMING_FREESTYLE_100M -> FREESTYLE_100M_URL;
            case  SWIMMING_FREESTYLE_200M ->
                    FREESTYLE_200M_URL;
            case  SWIMMING_FREESTYLE_400M->
                    FREESTYLE_400M_URL;
            case  SWIMMING_BREASTSTROKE_50M ->
                    BREASTSTROKE_50M_URL ;
            case  SWIMMING_BREASTSTROKE_100M ->
                    BREASTSTROKE_100M_URL;
            case SWIMMING_BREASTSTROKE_200M ->
                    BREASTSTROKE_200M_URL;
            default -> DEFAULT_URL;
        };
    }

}
