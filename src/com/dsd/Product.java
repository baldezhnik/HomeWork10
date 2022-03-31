package com.dsd;

class Product {
    private int id;
    private String name;
    private int price;

    Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "\nТовар " +"id=" + id +", Наименование='" + name + '\'' +", Цена=" + price +" руб";
    }
}
