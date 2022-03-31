package com.dsd;

public class Main {

    public static void main(String[] args) {
        Shop shop = new Shop();
        boolean checkExit = true;

        Product[] products = {new Product(1, "Coca", 500),
                new Product(2, "Lays", 200),
                new Product(3, "Beer", 100),
                new Product(4, "Milk", 400),
                new Product(5, "Meat", 500)};

        for (Product p : products) {
            shop.addProduct(p);
        }

        System.out.println("\tHomeWork");
        do {
            try {
                int sw = ConsoleMenu.mainMenu();
                switch (sw) {
                    case 0:
                        checkExit = false;
                        break;
                    case 1:
                        ConsoleMenu.showList(shop);
                        break;
                    case 2:
                        ConsoleMenu.addProduct(shop);
                        break;
                    case 3:
                        ConsoleMenu.removeProduct(shop);
                        break;
                    case 4:
                        ConsoleMenu.setProduct(shop);
                        break;
                    default:
                        throw new SwitchOutOfBoundsException("Пункт меню с номером " + sw + " отсутствует.");
                }
            } catch (ScannerCheckFormatException | SwitchOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }

        } while (checkExit);
        System.out.println("\n\tMade by Dmitry Drako (─‿‿─)");
    }

}

