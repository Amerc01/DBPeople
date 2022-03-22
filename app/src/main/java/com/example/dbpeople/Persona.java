package com.example.dbpeople;

public class Persona {
    String name;
    String surname;
    String email;
    String cf;
    String username;
    String password;
    String gender;

    public Persona(String name, String surname, String email, String cf, String username, String password, String gender) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.cf = cf;
        this.username = username;
        this.password = password;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCf(){
        return cf;
    }

    public void setCf(String cf){
        this.cf = cf;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
