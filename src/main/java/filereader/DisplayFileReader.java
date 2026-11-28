package filereader;

import model.display.DisplayBuilder;

import java.io.BufferedReader;

public class DisplayFileReader extends AbstractFileReader<DisplayBuilder> {

    public DisplayFileReader(BufferedReader reader) {
        super(reader);
    }

    @Override
    protected void fill(DisplayBuilder builder, String text, double decimal, int integer) {
        builder.setModel(text)
                .setDiagonal(decimal)
                .setRefreshRate(integer);
    }
}
