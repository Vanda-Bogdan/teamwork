package datareader;

import model.display.DisplayBuilder;

import java.util.Scanner;

public class DisplayConsoleReader implements ConsoleReader<DisplayBuilder> {

    private final Scanner scanner;

    public DisplayConsoleReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void readData(DisplayBuilder builder) {
        System.out.print("Введите модель: ");
        String model = scanner.nextLine();

        System.out.print("Введите диагональ: ");
        double diagonal = Double.parseDouble(scanner.nextLine());

        System.out.print("Введите частоту обновления: ");
        int refreshRate = Integer.parseInt(scanner.nextLine());

        builder.setModel(model)
                .setDiagonal(diagonal)
                .setRefreshRate(refreshRate);
    }
}
