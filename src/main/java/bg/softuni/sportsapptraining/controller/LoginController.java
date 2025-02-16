package bg.softuni.sportsapptraining.controller;

import bg.softuni.sportsapptraining.model.dto.UserLoginDto;
import bg.softuni.sportsapptraining.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(){

        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@Valid UserLoginDto data, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
             redirectAttributes.addFlashAttribute("loginData",data);
             redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginData",bindingResult);

            return "redirect:/login";
        }

       userService.login(data);

        return "redirect:/home";
    }



}
