package com.example.gameteam.entity;

public class Doctor {
    private int icon;
    private String name;
    private String profession = "医生";
    private int atk;

    public int getAtk() {
        return atk;
    }

    public Doctor(int icon, String name, int atk) {
        this.icon = icon;
        this.name = name;
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
}
