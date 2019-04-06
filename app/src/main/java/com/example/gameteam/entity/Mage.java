package com.example.gameteam.entity;

public class Mage{
    private int icon;
    private String name;
    private String profession = "法师";
    private int atk;

    public Mage(int icon, String name, int atk) {
        this.icon = icon;
        this.name = name;
        this.atk = atk;
    }
    public int getAtk() {
        return atk;
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
}
