import menu.*;
import datareader.DataReader;
import getdata.DataProvider;
import getdata.GetDataStrategy;
import getdata.RandomDataStrategy;
import getdata.ManualDataStrategy;
import model.EntityBuilder;
import sorter.Sorter;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {

    // private static final Scanner SCANNER = new Scanner(System.in);
    // private static final String FILE_PATH = "";

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            Menu menu = new Menu(scanner);

            boolean isRunning = true;
            while (isRunning) {

                menu.printMainMenu();

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 0 -> {
                        isRunning = false;
                    }
                    case 1 -> {
                        processEntity(new DisplayConfig(), menu, scanner);
                    }
                     case 2 -> {
                        processEntity(new AutomobileConfig(), menu, scanner);
                     }
                     case 3 -> {
                         processEntity(new ProductConfig(), menu, scanner);
                     }
                    default -> {
                        System.out.println("Неверный выбор.");
                        return;
                    }
                }
            }
        }
    }

    private static <T, B extends EntityBuilder<T>> void processEntity(EntityConfig<T, B> config, Menu menu, Scanner scanner) {
        int dataChoice = menu.chooseInputMethod();

        int size = 0;
        if (dataChoice == 1 || dataChoice == 2) {
            System.out.print("Введите количество объектов: ");
            size = Integer.parseInt(scanner.nextLine());
        }
        else if (dataChoice == 3) {
            return; //TODO Передает кол-во обьектов в size из файла
        }

        DataProvider<T> provider = new DataProvider<>();
        GetDataStrategy<T> strategy = null;

        B builder = config.createBuilder();

        switch (dataChoice) {
            case 1 -> {
                DataReader<B> reader = config.createReader(scanner);
                strategy = new ManualDataStrategy<>(builder, reader, size);
            }
            case 2 -> {
                Consumer<B> randomizer = config.createRandomizer(builder);
                strategy = new RandomDataStrategy<>(builder, randomizer, size);
            }
            case 3 -> {
                return; //TODO Подключение FileDataStrategy
            }
            default -> {
                System.out.println("Неверный выбор.");
                return;
            }
        }

        provider.setStrategy(strategy);
        List<T> data = provider.getData();

        Comparator<T> comparator = config.chooseSort(menu);
        if (comparator == null) {
            return;
        }
        Sorter.sort(data, comparator);

        System.out.println("\n--- Результат ---");
        data.forEach(item -> System.out.println(item.toString()));

        System.out.println("\nНажмите Enter, чтобы вернуться в меню...");
        scanner.nextLine();
    }
}