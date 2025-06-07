package bg.softuni.sportsapptraining.controller;

import bg.softuni.sportsapptraining.constant.DisciplineConstants;
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
            case  SWIMMING_FREESTYLE_50M  ->
                    "http://res.cloudinary.com/dccqkyfpt/image/upload/v1743496341/rnh11d92uf5zz92i2sxi.jpg";
            case  SWIMMING_FREESTYLE_100M ->
                    "http://res.cloudinary.com/dccqkyfpt/image/upload/v1743496406/g1efdnkby3uk9ndevgsb.jpg";
            case  SWIMMING_FREESTYLE_200M ->
                    "http://res.cloudinary.com/dccqkyfpt/image/upload/v1743593035/wdwnyhpv0xuziyol6bov.jpg";
            case  SWIMMING_FREESTYLE_400M->
                    "http://res.cloudinary.com/dccqkyfpt/image/upload/v1743593117/z4umctc6trkhstkg8bfq.jpg";
            case  SWIMMING_BREASTSTROKE_50M ->
                    "http://res.cloudinary.com/dccqkyfpt/image/upload/v1743593200/iwdolhnwfkaihmad0qqw.jpg";
            case  SWIMMING_BREASTSTROKE_100M ->
                    "http://res.cloudinary.com/dccqkyfpt/image/upload/v1743593302/baupzc4kgd4jqmiwtcvv.jpg";
            case SWIMMING_BREASTSTROKE_200M ->
                    "http://res.cloudinary.com/dccqkyfpt/image/upload/v1743593531/rizrl65bbw2nx6j6znkc.jpg";
            default -> "http://res.cloudinary.com/dccqkyfpt/image/upload/v1746034357/qt7a1jxfx2ciznle3pli.jpg";
        };
    }

}
