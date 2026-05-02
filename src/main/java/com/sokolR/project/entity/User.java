package com.sokolR.project.entity;

import java.util.List;

public class User {

    private long id;
    private String name;
    private String email;
    private Cart cart;
    private List<String> bucket; // Корзина покупок


    public User(long id, String name, String email, Cart cart, List<String> bucket) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cart = cart;
        this.bucket = bucket;
    }

    public User(Object o, String name, String email) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
