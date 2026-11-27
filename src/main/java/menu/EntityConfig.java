package menu;

import datareader.DataReader;
import model.EntityBuilder;

import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Consumer;

public interface EntityConfig<T, B extends EntityBuilder<T>> {
    B createBuilder();
    DataReader<B> createReader(Scanner scanner);
    Consumer<B> createRandomizer(B builder);
    //TODO Реализация метода из файла
    Comparator<T> chooseSort(Menu menu);
}