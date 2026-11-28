package getdata;

import filereader.FileReader;
import model.EntityBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class FileDataStrategy<T, B extends EntityBuilder<T>> implements GetDataStrategy<T> {

    private final B builder;
    private final Function<BufferedReader, FileReader<B>> readerFactory;
    private final Path path;

    public FileDataStrategy(
            B builder,
            Function<BufferedReader, FileReader<B>> readerFactory,
            Path path
    ) {
        this.builder = builder;
        this.readerFactory = readerFactory;
        this.path = path;
    }

    @Override
    public List<T> getData() {
        List<T> result = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(path)) {
            FileReader<B> reader = readerFactory.apply(br);

            while (true) {
                try {
                    reader.readData(builder);
                    result.add(builder.build());
                } catch (NoSuchElementException eof) {
                    break;
                }
            }
        } catch (IOException e) {
            throw new UncheckedIOException("Ошибка чтения файла: " + path, e);
        }

        return result;
    }
}
