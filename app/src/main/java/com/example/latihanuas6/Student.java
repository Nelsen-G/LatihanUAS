package com.example.latihanuas6;

public class Student {
    private String name, email;
    private int nim, hp;

    public Student(String name, String email, int nim, int hp) {
        this.name = name;
        this.email = email;
        this.nim = nim;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNim() {
        return nim;
    }

    public void setNim(int nim) {
        this.nim = nim;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
