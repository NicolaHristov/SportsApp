package bg.softuni.sportsapptraining.controller;

import bg.softuni.sportsapptraining.model.dto.RegisterDto;
import bg.softuni.sportsapptraining.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {


    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(){

        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@Valid RegisterDto data, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("registerData",data);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerData",bindingResult);

            return "redirect:/register";
        }

         boolean success = userService.register(data);

        if(!success){
            return "redirect:/register";
        }


        return "redirect:/login";
    }
}
