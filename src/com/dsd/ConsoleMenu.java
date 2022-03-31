package com.dsd;

import java.util.Scanner;

public abstract class ConsoleMenu {

    static int mainMenu() throws ScannerCheckFormatException {
        System.out.println("\n\tВыберите действие:\n" +
                "1. Показать список товаров\n" +
                "2. Добавить товар\n" +
                "3. Удалить товар\n" +
                "4. Редактировать товар\n" +
                "0. Выход из программы");
        return myScannerInt();
    }

    static void showList(Shop shop) throws SwitchOutOfBoundsException, ScannerCheckFormatException {
        System.out.println("Выберите порядок отображения:\n" +
                "1. По цене (возрастание)\n" +
                "2. По цене (убывание)\n" +
                "3. По дате добавления (сначала новые)\n" +
                "4. По дате добавления (сначла старые)");
        System.out.println(shop.sort(myScannerInt()).toString());
    }

    static void addProduct(Shop shop) throws ScannerCheckFormatException {
        System.out.println("Введите id товара, наименование и стоимость через запятую с пробелом.");
        shop.addProduct(myScannerProduct());
    }

    static void removeProduct(Shop shop) throws ScannerCheckFormatException {
        System.out.println("Введите id удаляемого товара.");
            shop.removeProduct(myScannerInt());
    }

    static void setProduct(Shop shop) throws ScannerCheckFormatException {
        System.out.println("Введите id редактируемого товара, новые наименование и стоимость через запятую с пробелом.");
        shop.setProduct(myScannerProduct());
    }

    static int myScannerInt () throws ScannerCheckFormatException {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) return scanner.nextInt();
        else throw new ScannerCheckFormatException("Неккоректный формат ввода, пожалуйста используйте целые числа.");
    }

    static Product myScannerProduct () throws ScannerCheckFormatException{
        Scanner scanner = new Scanner(System.in);
        int id;
        String name;
        int price;
        String stringShop = scanner.nextLine();
        String[] st = stringShop.split(", ",3);
        if (!(st.length==3)) throw new ScannerCheckFormatException("Неккоректный формат ввода (Прим.: 42, Bork, 600)");
        if (st[0].matches("\\d+")) id = Integer.parseInt(st[0]);
        else throw new ScannerCheckFormatException("Неккоректный формат ввода (Прим.: 42, Bork, 600)");
        if (st[1].matches("[\\w\\s]+")) name = st[1];
        else throw new ScannerCheckFormatException("Неккоректный формат ввода (Прим.: 42, Bork, 600)");
        if (st[2].matches("\\d+")) price = Integer.parseInt(st[2]);
        else throw new ScannerCheckFormatException("Неккоректный формат ввода (Прим.: 42, Bork, 600)");
        return new Product(id,name,price);
    }

}
