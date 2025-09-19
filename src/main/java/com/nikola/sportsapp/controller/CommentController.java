package com.nikola.sportsapp.controller;

import com.nikola.sportsapp.constant.ViewNames;
import com.nikola.sportsapp.model.Comment;
import com.nikola.sportsapp.model.Discipline;
import com.nikola.sportsapp.model.User;
import com.nikola.sportsapp.model.dto.CommentDto;
import com.nikola.sportsapp.model.dto.DisciplineDto;
import com.nikola.sportsapp.service.CommentService;
import com.nikola.sportsapp.service.DisciplineService;
import com.nikola.sportsapp.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;
    private final DisciplineService disciplineService;
    private final UserService userService;

    public CommentController(CommentService commentService, DisciplineService disciplineService, UserService userService) {
        this.commentService = commentService;
        this.disciplineService = disciplineService;
        this.userService = userService;
    }

    @GetMapping("/{disciplineId}")
    public String showCommentsForDiscipline(@PathVariable Long disciplineId, Model model, Principal principal) {
        DisciplineDto disciplineDto = disciplineService.getDisciplineById(disciplineId);

        List<CommentDto> commentsForDiscipline = commentService.findAllByDiscipline(disciplineId);
        model.addAttribute("comments", commentsForDiscipline);
        model.addAttribute("discipline", disciplineDto);
        model.addAttribute("selectedDiscipline", disciplineDto);
        model.addAttribute("isLogged", principal != null);

        return ViewNames.COMMENTS;
    }

    @PostMapping("/add")
    @PreAuthorize("isAuthenticated()")
    public String addComment(@RequestParam String content, @RequestParam Long disciplineId, Principal principal) {
        DisciplineDto disciplineDto = disciplineService.getDisciplineById(disciplineId);

        User user = userService.findByUsername(principal.getName());
        commentService.addComment(content,disciplineId,user);
        String sportPath = disciplineDto.getSportName().toLowerCase();

        return "redirect:/" + sportPath + "?disciplineId=" + disciplineDto.getId();
    }
}
