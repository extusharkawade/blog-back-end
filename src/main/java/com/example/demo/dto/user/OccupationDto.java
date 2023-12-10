package com.example.demo.dto.user;

import lombok.Getter;
import lombok.Setter;
public class OccupationDto {

    private int id;
    private String occupation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
