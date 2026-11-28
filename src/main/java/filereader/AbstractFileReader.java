package filereader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.NoSuchElementException;

public abstract class AbstractFileReader<B> implements FileReader<B> {

    protected final BufferedReader reader;

    protected AbstractFileReader(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public final void readData(B builder) {
        try {
            String line;
            do {
                line = reader.readLine();
                if (line == null) {
                    throw new NoSuchElementException("Файл закончился");
                }
            } while (line.isBlank());

            String[] parts = line.split(";");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Неверный формат строки: " + line);
            }

            String text    = parts[0].trim();
            double decimal = Double.parseDouble(parts[1].trim());
            int integer    = Integer.parseInt(parts[2].trim());

            fill(builder, text, decimal, integer);

        } catch (IOException e) {
            throw new UncheckedIOException("Ошибка чтения файла", e);
        }
    }

    protected abstract void fill(B builder, String text, double decimal, int integer);
}
