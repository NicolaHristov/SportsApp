package bg.softuni.sportsapptraining.controller;

import bg.softuni.sportsapptraining.model.enums.Role;
import bg.softuni.sportsapptraining.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/manage-users")
    public String manageUsers(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "admin-manage-users";
    }

//    @GetMapping("/change-role")
//    public String showChangeRolePage(@RequestParam("userId") Long userId, Model model) {
//        model.addAttribute("user", userService.findUserById(userId));
//        model.addAttribute("roles", Role.values());
//        return "admin/change-role";
//    }


    @PostMapping("/change-role")
    public String changeUserRole(@RequestParam("userId") Long userId, @RequestParam("newRole") String newRole) {

        userService.changeUserRole(userId, Role.valueOf(newRole));

        return "redirect:/admin/manage-users";
    }
}
