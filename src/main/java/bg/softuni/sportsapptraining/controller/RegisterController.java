package bg.softuni.sportsapptraining.controller;

import bg.softuni.sportsapptraining.config.UserSession;
import bg.softuni.sportsapptraining.model.dto.RegisterDto;
import bg.softuni.sportsapptraining.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {


    private final UserService userService;
    private final UserSession userSession;


    public RegisterController(UserService userService, UserSession userSession) {
        this.userService = userService;
        this.userSession = userSession;
    }

    @ModelAttribute("registerData")
    public RegisterDto registerDto(){
        return new RegisterDto();
    }

    @GetMapping("/register")
    public String register(){
        if(userSession.isUserLoggedIn()){
            return "redirect:/home";
        }
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@Valid RegisterDto data, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(userSession.isUserLoggedIn()){
            return "redirect:/home";
        }

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("registerData",data);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerData",bindingResult);

            return "redirect:/register";
        }

        boolean passwordDiff = data.getPassword().equals(data.getConfirmPassword());

        if(!passwordDiff){

            redirectAttributes.addFlashAttribute("passError",true);

            return "redirect:/register";
        }

         boolean success = userService.register(data);

        if(!success){
            return "redirect:/register";
        }

        return "redirect:/login";
    }
}
