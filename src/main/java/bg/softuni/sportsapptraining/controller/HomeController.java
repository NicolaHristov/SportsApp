package bg.softuni.sportsapptraining.controller;

import bg.softuni.sportsapptraining.config.UserSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class HomeController {


    private final UserSession userSession;
    public HomeController(UserSession userSession) {
        this.userSession = userSession;
    }

    @GetMapping("/")
    public String notLogged(){
        System.out.println("Checking session in /: ID = " + userSession.getId());
        if(userSession.isUserLoggedIn()){
            return "redirect:/home";
        }
        return "index";
    }

    @GetMapping("/home")
    public String loggedIn(){
        System.out.println("Checking session in /home: ID = " + userSession.getId());
        if(!userSession.isUserLoggedIn()){
            return "redirect:/";
        }

        return "/home";
    }


}
