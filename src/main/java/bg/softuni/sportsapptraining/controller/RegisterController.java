package bg.softuni.sportsapptraining.controller;

import bg.softuni.sportsapptraining.constant.ViewNames;
import bg.softuni.sportsapptraining.model.dto.RegisterDto;
import bg.softuni.sportsapptraining.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class RegisterController {


    private final UserService userService;


    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("registerData")
    public RegisterDto registerDto() {
        return new RegisterDto();
    }

    @GetMapping("/register")
    public String register(Principal principal) {
        if (principal != null) {
            return "redirect:/home";
        }
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@Valid RegisterDto data, BindingResult bindingResult, RedirectAttributes redirectAttributes, Principal principal) {

        if (principal != null) {
            return "redirect:/home";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registerData", data);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerData", bindingResult);

            return ViewNames.REDIRECT_REGISTER;
        }

        if (!data.getPassword().equals(data.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("passError", true);
            return ViewNames.REDIRECT_REGISTER;
        }

        boolean success = userService.register(data);

        if (!success) {
            return ViewNames.REDIRECT_REGISTER;
        }

        return "redirect:/login";
    }
}
