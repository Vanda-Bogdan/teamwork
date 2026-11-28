package getdata;

import datareader.ConsoleReader;
import model.EntityBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ManualDataStrategy<T, B extends EntityBuilder<T>> implements GetDataStrategy<T> {

    private final B builder;
    private final ConsoleReader<B> dataReader;
    private final int size;

    public ManualDataStrategy(
            B builder,
            ConsoleReader<B> dataReader,
            int size
    ) {
        this.builder = builder;
        this.dataReader = dataReader;
        this.size = size;
    }

    @Override
    public List<T> getData() {

//        List<T> result = new ArrayList<>();
//
//        for (int i = 0; i < size; i++) {
//
//            System.out.println("\nЗаполнение объекта №" + (i + 1));
//
//            dataReader.readData(builder);
//
//            T object = builder.build();
//
//            result.add(object);
//        }

        return IntStream.range(0, size)
                .mapToObj( i -> {
                    System.out.println("\nЗаполнение объекта №" + (i + 1));
                    dataReader.readData(builder);
                    return builder.build();
                })
                //.toList();
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
