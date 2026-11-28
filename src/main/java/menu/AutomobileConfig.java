package menu;

import datareader.AutomobileConsoleReader;
import datareader.ConsoleReader;
import filereader.AutomobileFileReader;
import filereader.FileReader;
import model.automobile.Automobile;
import model.automobile.AutomobileBuilder;
import randomizer.AutomobileRandomizer;

import java.io.BufferedReader;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Consumer;

public class AutomobileConfig implements EntityConfig<Automobile, AutomobileBuilder> {

    @Override
    public AutomobileBuilder createBuilder() {
        return new AutomobileBuilder();
    }

    @Override
    public ConsoleReader<AutomobileBuilder> createConsoleReader(Scanner scanner) {
        return new AutomobileConsoleReader(scanner);
    }

    @Override
    public Consumer<AutomobileBuilder> createRandomizer(AutomobileBuilder builder) {
        return new AutomobileRandomizer().automobileRandomizer;
    }

    @Override
    public FileReader<AutomobileBuilder> createFileReader(BufferedReader reader) {
        return new AutomobileFileReader(reader);
    }

    @Override
    public Comparator<Automobile> chooseSort(Menu menu) {
        return menu.chooseAutomobileSort();
    }
}