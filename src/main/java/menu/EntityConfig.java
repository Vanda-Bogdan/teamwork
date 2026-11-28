package menu;

import datareader.ConsoleReader;
import filereader.FileReader;
import model.EntityBuilder;

import java.io.BufferedReader;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Consumer;

public interface EntityConfig<T, B extends EntityBuilder<T>> {
    B createBuilder();
    ConsoleReader<B> createConsoleReader(Scanner scanner);
    Consumer<B> createRandomizer(B builder);
    FileReader<B> createFileReader(BufferedReader reader);
    Comparator<T> chooseSort(Menu menu);
}