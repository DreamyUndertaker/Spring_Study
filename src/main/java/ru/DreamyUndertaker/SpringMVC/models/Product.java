package ru.DreamyUndertaker.SpringMVC.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
    private int id;
    private String name;
    private String about;
    private String categories;
    private double price;
    private int ammount;
    private String date;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH:mm");

    public Product(int id, String name, String about, String categories, double price, int ammount, Date date) {
        this.id = id;
        this.name = name;
        this.date = dateFormat.format(date);
    }

    public Product(){

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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
