package com.example.gameteam.entity;

public class Weapon {
    private int icon;
    private String name;
    private String info;
    private int atk;
    private String profession;


        public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
        public Weapon(){}

    public Weapon(int icon,String name, String info, int atk, String profession) {
            this.icon = icon;
        this.name = name;
        this.info = info;
        this.atk = atk;
        this.profession = profession;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }
}
