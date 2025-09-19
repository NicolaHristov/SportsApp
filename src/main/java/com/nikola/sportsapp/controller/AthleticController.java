package com.nikola.sportsapp.controller;

import com.nikola.sportsapp.model.Comment;
import com.nikola.sportsapp.model.Discipline;
import com.nikola.sportsapp.model.dto.CommentDto;
import com.nikola.sportsapp.model.dto.DisciplineDto;
import com.nikola.sportsapp.service.AthleticsService;
import com.nikola.sportsapp.service.CommentService;
import com.nikola.sportsapp.service.DisciplineService;
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

        model.addAttribute("disciplines", athleticsService.getAllDisciplineDtos());

        if (disciplineId != null) {
            DisciplineDto selectedDto = disciplineService.getDisciplineById(disciplineId);
            List<CommentDto> comments = commentService.findAllByDiscipline(disciplineId);

            model.addAttribute("selectedDiscipline", selectedDto);
            model.addAttribute("comments", comments);
            model.addAttribute("championImageUrl",
                    athleticsService.getChampionImageUrl(selectedDto.getName()));
        }

        return "athletics";
    }

    @PostMapping("/athletics")
    public String selectDiscipline(@RequestParam("discipline") String disciplineName) {
        DisciplineDto selectedDto = athleticsService.getDisciplineByName(disciplineName);
        return "redirect:/athletics?disciplineId=" + selectedDto.getId();
    }

}
