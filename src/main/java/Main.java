import datareader.DisplayDataReader;
import getdata.*;
import model.display.Display;
import model.display.DisplayBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String FILE_PATH = "";

    public static void main(String[] args) {

        System.out.println("Выберите класс:");
        System.out.println("1. Display");
        System.out.println("2. Class2");
        System.out.println("3. Class3");

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
                        // Подключение RandomDataStrategy
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
            }

            case 2 -> {
                // Аналогичная настройка для Automobile
            }

            case 3 -> {
                // Аналогичная настройка для Product
            }

            default -> System.out.println("Неверный выбор.");
        }

        SCANNER.close();
    }

}
