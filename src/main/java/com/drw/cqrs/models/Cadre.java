package com.drw.cqrs.models;

public class Cadre {

    private String position;
    private boolean availability;

    public Cadre(){

    }

    public Cadre(String position, boolean availability) {
        this.position = position;
        this.availability = availability;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
