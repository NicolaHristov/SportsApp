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
    }

    public UserSession() {
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
}
