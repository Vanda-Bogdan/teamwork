package getdata;

import model.EntityBuilder;
import model.display.Display;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomDataStrategy<T, B extends EntityBuilder<T>> implements GetDataStrategy<T> {

    private final B builder;
    private final int size;
    private final Consumer<B> randomizer;

    public RandomDataStrategy(B builder, Consumer<B> randomizer, int size) {
        this.builder = builder;
        this.size = size;
        this.randomizer = randomizer;
    }

    @Override
    public List<T> getData() {

//        List<T> result = new ArrayList<>();
//
//        for (int i = 0; i < size; i++) {
//            // Здесь генерируются случайные значения
//            // и передаются в Builder.
//
//            result.add(builder.build());
//        }
//
//        return result;

        return IntStream.range(0, size)
                .mapToObj(i -> {
                    randomizer.accept(builder);
                    return builder.build();
                })
                //.toList();
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
