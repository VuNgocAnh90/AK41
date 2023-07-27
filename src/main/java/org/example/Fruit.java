package org.example;

import java.security.PrivateKey;

public class Fruit {
    private String name ;
    private String color;

    public Fruit(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public void info(){
        System.out.println(this.name + " is " + this.color);
    }
}

