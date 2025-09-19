package com.nikola.sportsapp.controller;

import com.nikola.sportsapp.model.dto.CommentDto;
import com.nikola.sportsapp.model.dto.DisciplineDto;
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
    public String showSwimming(@RequestParam(name = "disciplineId", required = false) Long disciplineId,
                               Model model) {

        model.addAttribute("disciplines", swimmingService.getAllDisciplineDtos());

        if (disciplineId != null) {
            DisciplineDto selectedDto = swimmingService.getDisciplineById(disciplineId);
            List<CommentDto> comments = commentService.findAllByDiscipline(disciplineId);

            model.addAttribute("selectedDiscipline", selectedDto);
            model.addAttribute("comments", comments);
            model.addAttribute("championImageUrl",
                    swimmingService.getChampionImageUrl(selectedDto.getName()));
        }

        return "swimming";
    }

    @PostMapping
    public String selectDiscipline(@RequestParam("discipline") String disciplineName) {
        DisciplineDto selectedDto = swimmingService.getDisciplineByName(disciplineName);
        return "redirect:/swimming?disciplineId=" + selectedDto.getId();
    }

}
