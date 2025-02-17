package bg.softuni.sportsapptraining.service;

import bg.softuni.sportsapptraining.config.UserSession;
import bg.softuni.sportsapptraining.model.User;
import bg.softuni.sportsapptraining.model.dto.RegisterDto;
import bg.softuni.sportsapptraining.model.dto.UserLoginDto;
import bg.softuni.sportsapptraining.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserSession userSession;

    public UserService(UserRepository userRepository, UserSession userSession) {
        this.userRepository = userRepository;
        this.userSession = userSession;
    }

    public boolean register(RegisterDto data){
        Optional<User>existingUser =userRepository.findByUsernameOrEmail(data.getUsername(),data.getEmail());

        if(existingUser.isPresent()){
            return false;
        }

        User user = new User();

        user.setUsername(data.getUsername());
        user.setPassword(data.getPassword());
        user.setEmail(data.getEmail());

        this.userRepository.save(user);

        return true;
    }

    public boolean login(UserLoginDto data) {
        Optional<User> byUsername = userRepository.findByUsername(data.getUsername());

       if(byUsername.isEmpty()){
           return false;
       }

       User user = byUsername.get();

        userSession.login(user);

        return true;
    }

    public void logout() {
         userSession.logout();
    }
}
