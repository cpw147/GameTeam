package com.example.gameteam.entity;

import java.io.Serializable;

public class Character implements Serializable {
    private int icon;
    private String name;
    private String profession;
    private int atk;

    public Character(int icon, String name, String profession, int atk) {
        this.icon = icon;
        this.name = name;
        this.profession = profession;
        this.atk = atk;
    }

    public int getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public String getProfession() {
        return profession;
    }

    public int getAtk() {
        return atk;
    }
}
