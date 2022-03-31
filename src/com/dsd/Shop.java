package com.dsd;

import java.util.*;

public class Shop {
    private List<Product> list = new LinkedList<>();

    public Shop() {
    }

    public void addProduct(Product product) {
        for (Product productIt : this.list) {
            if (productIt.getId() == product.getId()) {
                System.out.println("Отказано в добавлении товара. Товар с id = " + product.getId() + " существует.");
                return;
            }
        }
        this.list.add(product);
        System.out.println("Товар добавлен");
    }

    public void removeProduct(int id) {
        Iterator<Product> iterator = this.list.listIterator();
        while (iterator.hasNext()) {
            Product productIt = iterator.next();
            if (productIt.getId() == id) {
                this.list.remove(productIt);
                System.out.println("Товар с id = "+ id + " удален.");
                return;
            }
        }
        System.out.println("Товар с id = "+ id + " отсутсвует.");
    }

    public void setProduct(Product product) {
        for (Product productIt : this.list) {
            if (productIt.getId() == product.getId()) {
                this.list.set(this.list.indexOf(productIt), product);
                System.out.println("Товар с id = "  + product.getId() +  " изменен.");
                return;
            }
        }
        System.out.println("Товар с id = "  + product.getId() +  " отсутсвует.");
    }

    public List<Product> sort(int sw) throws SwitchOutOfBoundsException {
        List<Product> listSort = new LinkedList<>(List.copyOf(this.list));
        switch (sw) {
            case 1:
                listSort.sort(Comparator.comparing(Product::getPrice));
                break;
            case 2:
                listSort.sort(Comparator.comparing(Product::getPrice).reversed());
                break;
            case 3:
                Collections.reverse(listSort);
                break;
            case 4:
                break;
            default:
                throw new SwitchOutOfBoundsException("Пункт меню с номером " + sw + " отсутствует.");
        }

        return listSort;

    }

}
