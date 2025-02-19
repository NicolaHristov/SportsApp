package bg.softuni.sportsapptraining.controller;

import bg.softuni.sportsapptraining.config.UserSession;
import bg.softuni.sportsapptraining.model.dto.UserLoginDto;
import bg.softuni.sportsapptraining.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    private final UserService userService;
    private final UserSession userSession;

    @ModelAttribute("loginData")
    public UserLoginDto loginDto(){
        return new UserLoginDto();
    }

    public LoginController(UserService userService, UserSession userSession) {
        this.userService = userService;
        this.userSession = userSession;
    }

    @GetMapping("/login")
    public String login(){
       if(userSession.isUserLoggedIn()){
           return "redirect:/home";
       }
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@Valid UserLoginDto data, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(userSession.isUserLoggedIn()){
            return "redirect:/home";
        }

        if(bindingResult.hasErrors()){
             redirectAttributes.addFlashAttribute("loginData",data);
             redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginData",bindingResult);

            return "redirect:/login";
        }

         boolean success = userService.login(data);

        if(!success){
            redirectAttributes.addFlashAttribute("loginError",true);

            return "redirect:/login";
        }

        return "redirect:/home";
    }

    @PostMapping("/logout")
    public String logout(){
        userService.logout();

        return "redirect:/";
    }



}
