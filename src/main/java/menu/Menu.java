package menu;

import model.automobile.Automobile;
import model.display.Display;
import model.product.Product;

import java.util.Comparator;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printMainMenu() {
        System.out.println("Выберите класс:");
        System.out.println("1. Display");
        System.out.println("2. Automobile");
        System.out.println("3. Product");
        System.out.println("0. Выход");
    }


    public int chooseInputMethod() {
        System.out.println("Выберите способ получения данных:");
        System.out.println("1. Вручную");
        System.out.println("2. Случайно");
        System.out.println("3. Из файла");
        return Integer.parseInt(scanner.nextLine());
    }

    public Comparator<Display> chooseDisplaySort() {
        System.out.println("\nВыберите способ сортировки Display:");
        System.out.println("1. По умолчанию (Модель -> Диагональ -> Частота)");
        System.out.println("2. По модели (А-Я)");
        System.out.println("3. По диагонали (по возрастанию)");
        System.out.println("4. По диагонали (по убыванию)");
        System.out.println("5. По частоте обновления (по убыванию)");

        int choice = Integer.parseInt(scanner.nextLine());
        return switch (choice) {
            case 1 -> Display.DEFAULT_SORT;
            case 2 -> Display.BY_MODEL;
            case 3 -> Display.BY_DIAGONAL;
            case 4 -> Display.BY_DIAGONAL.reversed();
            case 5 -> Display.BY_REFRESH_RATE.reversed();
            default -> {
                System.out.println("Неверный выбор.");
                yield null;
            }
        };
    }

//    public Comparator<Automobile> chooseAutomobileSort() {
//        System.out.println("\nВыберите способ сортировки Automobile:");
//        System.out.println("1. По умолчанию (Модель -> Год -> Мощность)");
//        System.out.println("2. По модели (А-Я)");
//        System.out.println("3. По году (от старых к новым)");
//        System.out.println("4. По мощности (по убыванию)");
//
//        int choice = Integer.parseInt(scanner.nextLine());
//        return switch (choice) {
//            case 1 -> Automobile.DEFAULT_SORT;
//            case 2 -> Automobile.BY_MODEL;
//            case 3 -> Automobile.BY_YEAR;
//            case 4 -> Automobile.BY_POWER.reversed();
//            default -> {
//                System.out.println("Неверный выбор.");
//                yield null;
//            }
//        };
//    }
//
//    public Comparator<Product> chooseProductSort() {
//        System.out.println("\nВыберите способ сортировки Product:");
//        System.out.println("1. По умолчанию (Название -> Цена -> Количество)");
//        System.out.println("2. По названию (А-Я)");
//        System.out.println("3. По цене (от дешевых к дорогим)");
//        System.out.println("4. По цене (от дорогих к дешевым)");
//        System.out.println("5. По количеству (по убыванию)");
//
//        int choice = Integer.parseInt(scanner.nextLine());
//        return switch (choice) {
//            case 1 -> Product.DEFAULT_SORT;
//            case 2 -> Product.BY_NAME;
//            case 3 -> Product.BY_PRICE;
//            case 4 -> Product.BY_PRICE.reversed();
//            case 5 -> Product.BY_QUANTITY.reversed();
//            default -> {
//                System.out.println("Неверный выбор.");
//                yield null;
//            }
//        };
//    }
}
