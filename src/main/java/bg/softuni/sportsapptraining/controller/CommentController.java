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

    @GetMapping
    public String showComments(Model model, Principal principal) {
        List<Comment> comments = commentService.findAll();

        model.addAttribute("comments", comments);
        model.addAttribute("isLogged", principal != null);

        return "comments";
    }

    @GetMapping("/{disciplineId}")
    public String showCommentsForDiscipline(@PathVariable Long disciplineId, Model model, Principal principal) {
        Discipline discipline = disciplineService.getDisciplineById(disciplineId);

        List<Comment> commentsForDiscipline = commentService.findByDiscipline(discipline);
        model.addAttribute("comments", commentsForDiscipline);
        model.addAttribute("discipline", discipline);
        model.addAttribute("selectedDiscipline", discipline);
        model.addAttribute("isLogged", principal != null);

        return "comments";
    }

    @PostMapping("/add")
    @PreAuthorize("isAuthenticated()")
    public String addComment(@RequestParam String content, @RequestParam Long disciplineId, Principal principal) {
        Discipline discipline = disciplineService.getDisciplineById(disciplineId);
        User user = userService.findByUsername(principal.getName());

        Comment comment = new Comment(content, user, discipline);

        commentService.save(comment);

        String sportPath = discipline.getSport().getName().toLowerCase();

        return "redirect:/" + sportPath + "?discipline=" + discipline.getName();
    }

//    @PostMapping("/comments/add")
//    @PreAuthorize("isAuthenticated()")
//    public String addComment(@RequestParam Long disciplineId, @RequestParam String content, Principal principal) {
//        User user = userService.findByUsername(principal.getName());
//        Discipline discipline = disciplineService.getDisciplineById(disciplineId);
//        Comment comment = new Comment(content, user, discipline);
//
//        commentService.save(comment);
//        return "redirect:/athletics";
//    }


}
