package com.example.javaservletjdbc.model;

public class User {

    private int id;
    private String nome;
    private String email;
    private String country;

    public User(){}

    public User(String nome, String email, String country){
        super();
        this.nome = nome;
        this.email = email;
        this.country = country;
    }

    public User(int id, String nome, String email, String country){
        super();
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
