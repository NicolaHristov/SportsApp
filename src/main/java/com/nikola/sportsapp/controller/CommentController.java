package com.nikola.sportsapp.controller;

import com.nikola.sportsapp.constant.ViewNames;
import com.nikola.sportsapp.model.Comment;
import com.nikola.sportsapp.model.Discipline;
import com.nikola.sportsapp.model.User;
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
        Discipline discipline = disciplineService.getDisciplineById(disciplineId);

        List<Comment> commentsForDiscipline = commentService.findByDiscipline(discipline);
        model.addAttribute("comments", commentsForDiscipline);
        model.addAttribute("discipline", discipline);
        model.addAttribute("selectedDiscipline", discipline);
        model.addAttribute("isLogged", principal != null);

        return ViewNames.COMMENTS;
    }

    @PostMapping("/add")
    @PreAuthorize("isAuthenticated()")
    public String addComment(@RequestParam String content, @RequestParam Long disciplineId, Principal principal) {
        Discipline discipline = disciplineService.getDisciplineById(disciplineId);

        User user = userService.findByUsername(principal.getName());
        Comment comment = new Comment(content, user, discipline);
        commentService.save(comment);
        String sportPath = discipline.getSport().getName().toLowerCase();

        return "redirect:/" + sportPath + "?disciplineId=" + discipline.getId();
    }
}
