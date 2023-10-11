package fr.workshop.respectboundsbackend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Credentials {
    private String username;
    private String password;

    // Getters and setters

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


