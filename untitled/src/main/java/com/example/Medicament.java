package com.example;

public class Medicament {
    private static int counter = 1;
    private int id;
    private String name;
    private double price;

    public Medicament(String name, double price) {
        this.id = counter++;
        this.name = name;
        this.price = price;
    }

    public Medicament() {
        this.id = counter++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
