package com.example.bola_0123;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MatchResponse {
    @SerializedName("events")
    private ArrayList<Match> events;

    public ArrayList<Match> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Match> results) {
        this.events = events;
    }


}



