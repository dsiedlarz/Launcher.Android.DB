package com.example.dawid.lan;




public class Product {

    private String string;
    private int id;

    public int getId() {
        return id;
    }

    public String getString() {
        return string;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Product() {
    }

    public Product(int id, String string) {
        this.id = id;
        this.string = string;
    }

    public Product(String string) {
        this.string = string;
    }

    public Product(int id) {

        this.id = id;
    }
}