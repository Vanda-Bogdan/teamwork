import datareader.DisplayDataReader;
import getdata.*;
import model.display.Display;
import model.display.DisplayBuilder;
import randomizer.DisplayRandomizer;
import sorter.Sorter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String FILE_PATH = "";

    public static void main(String[] args) {

        System.out.println("Выберите класс:");
        System.out.println("1. Display");
        System.out.println("2. Automobile");
        System.out.println("3. Product");

        int classChoice = Integer.parseInt(SCANNER.nextLine());

        System.out.println("Выберите способ получения данных:");
        System.out.println("1. Вручную");
        System.out.println("2. Случайно");
        System.out.println("3. Из файла");

        int dataChoice = Integer.parseInt(SCANNER.nextLine());

        int size = 0;
        if (dataChoice == 1 || dataChoice == 2) {
            System.out.print("Введите количество объектов: ");
            size = Integer.parseInt(SCANNER.nextLine());
        }

        switch (classChoice) {

            case 1 -> {

                DataProvider<Display> provider = new DataProvider<>();
                List<Display> list = new ArrayList<>();

                switch (dataChoice) {

                    case 1 -> {

                        DisplayBuilder builder = new DisplayBuilder();
                        DisplayDataReader dataReader = new DisplayDataReader(SCANNER);

                        ManualDataStrategy<Display, DisplayBuilder> strategy =
                                new ManualDataStrategy<>(
                                        builder,
                                        dataReader,
                                        size
                                );

                        provider.setStrategy(strategy);
                    }

                    case 2 -> {
                        DisplayBuilder builder = new DisplayBuilder();
                        Consumer<DisplayBuilder> displayRandomizer = new DisplayRandomizer().displayRandomizer;

                        RandomDataStrategy<Display, DisplayBuilder> strategy =
                                new RandomDataStrategy<>(
                                        builder,
                                        displayRandomizer,
                                        size
                                );

                        provider.setStrategy(strategy);
                    }

                    case 3 -> {
                        // Подключение FileDataStrategy
                    }

                    default -> System.out.println("Неверный выбор.");
                }

                List<Display> displays = provider.getData();


                displays.forEach(display ->
                        System.out.println(display.getModel())
                );

                System.out.println("\nВыберите способ сортировки Display:");
                System.out.println("1. По умолчанию (Модель -> Диагональ -> Частота)");
                System.out.println("2. По модели (А-Я)");
                System.out.println("3. По диагонали (по возрастанию)");
                System.out.println("4. По диагонали (по убыванию)");
                System.out.println("5. По частоте обновления (по убыванию)");
                int sortChoice = Integer.parseInt(SCANNER.nextLine());

                switch (sortChoice) {
                    case 1 -> Sorter.sort(displays, Display.DEFAULT_SORT);
                    case 2 -> Sorter.sort(displays, Display.BY_MODEL);
                    case 3 -> Sorter.sort(displays, Display.BY_DIAGONAL);
                    case 4 -> Sorter.sort(displays, Display.BY_DIAGONAL.reversed());
                    case 5 -> Sorter.sort(displays, Display.BY_REFRESH_RATE.reversed());
                    default -> System.out.println("Неверный выбор, сортировка не применена.");
                }

                System.out.println("\n--- Результат ---");
                displays.forEach(d ->
                        System.out.printf("Модель: %-15s | Диагональ: %.1f | Частота: %d Гц%n",
                                d.getModel(), d.getDiagonal(), d.getRefreshRate())
                );
            }

            case 2 -> {
                // Аналогичная настройка для Automobile

                /*
                System.out.println("\nВыберите способ сортировки Automobile:");
                System.out.println("1. По умолчанию (Модель -> Год -> Мощность)");
                System.out.println("2. По модели (А-Я)");
                System.out.println("3. По году (от старых к новым)");
                System.out.println("4. По мощности (по убыванию)");
                int sortChoice = Integer.parseInt(SCANNER.nextLine());

                switch (sortChoice) {
                    case 1 -> Sorter.sort(autos, Automobile.DEFAULT_SORT);
                    case 2 -> Sorter.sort(autos, Automobile.BY_MODEL);
                    case 3 -> Sorter.sort(autos, Automobile.BY_YEAR);
                    case 4 -> Sorter.sort(autos, Automobile.BY_POWER.reversed());
                    default -> System.out.println("Неверный выбор, сортировка не применена.");
                }

                System.out.println("\n--- Результат ---");
                autos.forEach(a ->
                    System.out.printf("Модель: %-20s | Мощность: %6.1f л.с. | Год: %d%n",
                        a.getModel(), a.getEnginePower(), a.getYear())
                );
                */
            }

            case 3 -> {
                // Аналогичная настройка для Product

                /*
                 System.out.println("\nВыберите способ сортировки Product:");
                System.out.println("1. По умолчанию (Название -> Цена -> Количество)");
                System.out.println("2. По названию (А-Я)");
                System.out.println("3. По цене (от дешевых к дорогим)");
                System.out.println("4. По цене (от дорогих к дешевым)");
                System.out.println("5. По количеству (по убыванию)");
                int sortChoice = Integer.parseInt(SCANNER.nextLine());

                switch (sortChoice) {
                    case 1 -> Sorter.sort(products, Product.DEFAULT_SORT);
                    case 2 -> Sorter.sort(products, Product.BY_NAME);
                    case 3 -> Sorter.sort(products, Product.BY_PRICE);
                    case 4 -> Sorter.sort(products, Product.BY_PRICE.reversed());
                    case 5 -> Sorter.sort(products, Product.BY_QUANTITY.reversed());
                    default -> System.out.println("Неверный выбор, сортировка не применена.");
                }

                System.out.println("\n--- Результат ---");
                products.forEach(p ->
                    System.out.printf("Название: %-15s | Цена: %8.2f | Кол-во: %d%n",
                        p.getName(), p.getPrice(), p.getQuantity())
                );
                */
            }

            default -> System.out.println("Неверный выбор.");
        }

        SCANNER.close();
    }

}
