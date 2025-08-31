package com.nikola.sportsapp.controller;

import com.nikola.sportsapp.model.enums.Role;
import com.nikola.sportsapp.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.file.AccessDeniedException;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAnyRole('ADMIN','SUPER_ADMIN')")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/manage-users")
    public String manageUsers(Model model) {
        model.addAttribute("users", userService.findAllUsersDto());
        return "admin-manage-users";
    }
    @PostMapping("/change-role")
    public String changeUserRole(@RequestParam("userId") Long userId, @RequestParam("newRole") String newRole) throws AccessDeniedException {

        userService.changeUserRole(userId, Role.valueOf(newRole));

        return "redirect:/admin/manage-users";
    }
}
