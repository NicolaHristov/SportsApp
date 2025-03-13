package bg.softuni.sportsapptraining.controller;

import bg.softuni.sportsapptraining.model.Comment;
import bg.softuni.sportsapptraining.model.Discipline;
import bg.softuni.sportsapptraining.model.User;
import bg.softuni.sportsapptraining.service.CommentService;
import bg.softuni.sportsapptraining.service.DisciplineService;
import bg.softuni.sportsapptraining.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
//@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;
    private final DisciplineService disciplineService;
    private final UserService userService;

    public CommentController(CommentService commentService, DisciplineService disciplineService, UserService userService) {
        this.commentService = commentService;
        this.disciplineService = disciplineService;
        this.userService = userService;
    }

    @GetMapping("/comments")
    public String showComments(Model model){
          List<Comment> comments = commentService.findAll();

          model.addAttribute("comments",comments);

        return "comments";
    }

    @PostMapping("/comments")
    @PreAuthorize("isAuthenticated()")
    public String addComment(@RequestParam String commentContent, Principal principal){
        User user = userService.findByUsername(principal.getName());

        Comment comment = new Comment();
        comment.setUser(user);
        comment.setContent(commentContent);
        commentService.save(comment);

        return "redirect:/comments";
    }



}
