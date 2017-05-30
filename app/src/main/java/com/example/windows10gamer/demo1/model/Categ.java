package com.example.windows10gamer.demo1.model;

/**
 * Created by Windows 10 Gamer on 30/05/2017.
 */

public class Categ {
    public int Id;
    public String Name;
    public String Image;

    public Categ(int id, String name, String image) {
        Id = id;
        Name = name;
        Image = image;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setImage(String image) {
        Image = image;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getImage() {
        return Image;
    }
}
