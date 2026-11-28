package menu;

import datareader.ConsoleReader;
import datareader.DisplayConsoleReader;
import filereader.DisplayFileReader;
import filereader.FileReader;
import model.display.Display;
import model.display.DisplayBuilder;
import randomizer.DisplayRandomizer;

import java.io.BufferedReader;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Consumer;

public class DisplayConfig implements EntityConfig<Display, DisplayBuilder> {

    @Override
    public DisplayBuilder createBuilder() {
        return new DisplayBuilder();
    }

    @Override
    public ConsoleReader<DisplayBuilder> createConsoleReader(Scanner scanner) {
        return new DisplayConsoleReader(scanner);
    }

    @Override
    public Consumer<DisplayBuilder> createRandomizer(DisplayBuilder builder) {
        return new DisplayRandomizer().displayRandomizer;
    }

    @Override
    public FileReader<DisplayBuilder> createFileReader(BufferedReader reader) {
        return new DisplayFileReader(reader);
    }

    @Override
    public Comparator<Display> chooseSort(Menu menu) {
        return menu.chooseDisplaySort();
    }
}