package menu;

import datareader.DataReader;
import datareader.DisplayDataReader;
import model.display.Display;
import model.display.DisplayBuilder;
import randomizer.DisplayRandomizer;

import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Consumer;

public class DisplayConfig implements EntityConfig<Display, DisplayBuilder> {

    @Override
    public DisplayBuilder createBuilder() {
        return new DisplayBuilder();
    }

    @Override
    public DataReader<DisplayBuilder> createReader(Scanner scanner) {
        return new DisplayDataReader(scanner);
    }

    @Override
    public Consumer<DisplayBuilder> createRandomizer(DisplayBuilder builder) {
        return new DisplayRandomizer().displayRandomizer;
    }

    @Override
    public Comparator<Display> chooseSort(Menu menu) {
        return menu.chooseDisplaySort();
    }
}