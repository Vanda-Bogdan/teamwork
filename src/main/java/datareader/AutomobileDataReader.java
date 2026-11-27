package datareader;

import model.automobile.AutomobileBuilder;

import java.util.Scanner;

public class AutomobileDataReader implements DataReader<AutomobileBuilder> {

    private final Scanner scanner;

    public AutomobileDataReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void readData(AutomobileBuilder builder) {
        System.out.print("Введите модель автомобиля: ");
        String model = scanner.nextLine();

        System.out.print("Введите мощность двигателя (л.с.): ");
        double enginePower = Double.parseDouble(scanner.nextLine());

        System.out.print("Введите год производства: ");
        int year = Integer.parseInt(scanner.nextLine());

        builder.setModel(model)
                .setEnginePower(enginePower)
                .setYear(year);
    }
}