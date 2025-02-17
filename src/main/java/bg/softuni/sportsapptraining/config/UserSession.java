package bg.softuni.sportsapptraining.config;

import bg.softuni.sportsapptraining.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class UserSession {

    private long id;
    private String username;

    public void login(User user){
        this.id = user.getId();
        this.username = user.getUsername();
        System.out.println("User logged in: ID = " + id + ", Username = " + username);
    }

    public boolean isUserLoggedIn(){
        System.out.println("Checking if user is logged in: ID = " + id);
        return id != 0;
    }

    public UserSession() {
        System.out.println("New UserSession created!");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void logout() {
        System.out.println("User logged out: ID was " + id);
        this.id = 0;
        this.username = "";
    }
}
