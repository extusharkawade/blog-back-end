package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Table
@Entity
@Component
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id=0;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String occupation;

    public User(String username, String email, String occupation) {
        this.username = username;
        this.email = email;
        this.occupation = occupation;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
