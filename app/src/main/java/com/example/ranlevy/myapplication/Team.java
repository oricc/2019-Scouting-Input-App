package com.example.ranlevy.myapplication;

/**
 * Created by ranlevy on 26/02/2018.
 */

public class Team {
    Long Number;
    String Name;

    public Long getNumber() {
        return Number;
    }

    public String getNumberAsString(){
        return Long.toString(Number);
    }

    public String getName() {
        return Name;
    }
}
