package bg.softuni.sportsapptraining.controller;

import bg.softuni.sportsapptraining.model.Comment;
import bg.softuni.sportsapptraining.model.Discipline;
import bg.softuni.sportsapptraining.service.CommentService;
import bg.softuni.sportsapptraining.service.SwimmingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class SwimmingController {


    private final SwimmingService swimmingService;
    private final CommentService commentService;

    public SwimmingController(SwimmingService swimmingService, CommentService commentService) {
        this.swimmingService = swimmingService;
        this.commentService = commentService;
    }

    @GetMapping("/swimming")
    public String swimming(Model model){
        model.addAttribute("disciplines", swimmingService.getAllDisciplines());
        return "swimming";
    }


    @PostMapping("/swimming")
    public String getSwimming(@RequestParam ("discipline") String discipline, Model model, Principal principal){
        Discipline selectedDiscipline = swimmingService.getDisciplineByName(discipline);
        List<Comment> comments = commentService.findByDiscipline(selectedDiscipline);

        String championImageUrl = getChampionImageUrl(discipline);

        model.addAttribute("selectedDiscipline", selectedDiscipline);
        model.addAttribute("disciplines", swimmingService.getAllDisciplines());
        model.addAttribute("championImageUrl", championImageUrl);
        model.addAttribute("comments", comments);
        model.addAttribute("isAuthenticated", principal != null);

        return "swimming";
    }

    private String getChampionImageUrl(String discipline) {
        return switch (discipline) {
            case "50m freestyle" -> " http://res.cloudinary.com/dccqkyfpt/image/upload/v1743496341/rnh11d92uf5zz92i2sxi.jpg";
            case "100m freestyle" -> "http://res.cloudinary.com/dccqkyfpt/image/upload/v1743496406/g1efdnkby3uk9ndevgsb.jpg";
            default -> "https://res.cloudinary.com/default.jpg";
        };
    }

}
