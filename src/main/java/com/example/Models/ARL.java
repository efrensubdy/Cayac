package com.example.Models;

/**
 * Created by HSEQ on 24/03/2017.
 */
public class ARL {
    int id;
    String name;
    public ARL(){

    }
    public ARL(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
