package com.example.ranlevy.myapplication;

/**
 * Created by ranlevy on 26/02/2018.
 */

public class Team {
    Long Number;
    String Name;

    public Team(){
        Number = 0L;
        Name = "";
    }
    public Team(Long number,String name){
        this.Name = name;
        this.Number = number;
    }
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
