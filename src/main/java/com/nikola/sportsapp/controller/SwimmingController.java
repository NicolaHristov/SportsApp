package com.nikola.sportsapp.controller;

import com.nikola.sportsapp.model.Comment;
import com.nikola.sportsapp.model.Discipline;
import com.nikola.sportsapp.service.CommentService;
import com.nikola.sportsapp.service.SwimmingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

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
                   swimmingService.getChampionImageUrl(selected.getName()));
        }

        return "swimming";
    }

    @PostMapping
    public String selectDiscipline(@RequestParam("discipline") String disciplineName) {
        Discipline selected = swimmingService.getDisciplineByName(disciplineName);
        return "redirect:/swimming?disciplineId=" + selected.getId();
    }

}
