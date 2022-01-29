package com.bookstore;

public class Book{

    private int id;
    private String name;
    private String author;
    private int pages;

    private double price;
    private int stock;

    public Book(String name, String author, int pages, double price, int stock) {
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.price = price;
        this.stock = stock;
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

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
