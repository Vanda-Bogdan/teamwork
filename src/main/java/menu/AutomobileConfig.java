package menu;

import datareader.AutomobileDataReader;
import datareader.DataReader;
import model.automobile.Automobile;
import model.automobile.AutomobileBuilder;
import randomizer.AutomobileRandomizer;

import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Consumer;

public class AutomobileConfig implements EntityConfig<Automobile, AutomobileBuilder> {

    @Override
    public AutomobileBuilder createBuilder() {
        return new AutomobileBuilder();
    }

    @Override
    public DataReader<AutomobileBuilder> createReader(Scanner scanner) {
        // Вам нужно будет создать этот класс (по аналогии с DisplayDataReader)
        return new AutomobileDataReader(scanner);
    }

    @Override
    public Consumer<AutomobileBuilder> createRandomizer(AutomobileBuilder builder) {
        return new AutomobileRandomizer().automobileRandomizer;
    }

    @Override
    public Comparator<Automobile> chooseSort(Menu menu) {
        return menu.chooseAutomobileSort();
    }
}