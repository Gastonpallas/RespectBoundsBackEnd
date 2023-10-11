package fr.workshop.respectboundsbackend.Controller;

import fr.workshop.respectboundsbackend.entity.Experience;
import fr.workshop.respectboundsbackend.entity.User;
import fr.workshop.respectboundsbackend.service.ExperienceService;
import fr.workshop.respectboundsbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import fr.workshop.respectboundsbackend.model.Credentials;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/user")
@CrossOrigin
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
    this.userService = userService;
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Credentials credentials) {
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        Optional<User> user = this.userService.getUserByUsername(username);
        if (user.isEmpty()) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized. Status 401.");
        String validPassword = user.get().getPassword();
        String validUsername = user.get().getUsername();

        if (username != null && password != null && username.equals(validUsername) && password.equals(validPassword)) {
            return ResponseEntity.ok("Login successful. Status 200.");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized. Status 401.");
    }
}
