package getdata;

import datareader.DataReader;
import model.EntityBuilder;

import java.util.ArrayList;
import java.util.List;

public class ManualDataStrategy<T, B extends EntityBuilder<T>> implements GetDataStrategy<T> {

    private final B builder;
    private final DataReader<B> dataReader;
    private final int size;

    public ManualDataStrategy(
            B builder,
            DataReader<B> dataReader,
            int size
    ) {
        this.builder = builder;
        this.dataReader = dataReader;
        this.size = size;
    }

    @Override
    public List<T> getData() {

        List<T> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {

            System.out.println("\nЗаполнение объекта №" + (i + 1));

            dataReader.readData(builder);

            T object = builder.build();

            result.add(object);
        }

        return result;
    }
}
